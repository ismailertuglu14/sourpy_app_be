package org.sourpy.ecomapp.Service;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.UserApiRequest;
import org.sourpy.ecomapp.Dto.UserApiResponse;
import org.sourpy.ecomapp.Dto.UserApiTypes;
import org.sourpy.ecomapp.Entity.UserApi;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Repository.UserApiRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserApiService {
    private final UserApiRepository userApiRepository;
    private final UserService userService;

    public UserApi createApi(UserApiRequest apiInfo) {
        User user = userService.getUser(apiInfo.getUser_id());
        return userApiRepository.save(UserApi.builder()
                .apiKey(apiInfo.getApi_key())
                .apiSecretKey(apiInfo.getApi_secret_key())
                .sellerId(apiInfo.getSeller_id())
                .user(user)
                .userApiType(apiInfo.getApi_type())
                .build()
        );
    }

    public List<UserApiResponse> getUserApis(Long userId) {
        return userService.getUser(userId).getUserApis()
                .stream()
                .map(userApi -> UserApiResponse.builder()
                        .api_key(userApi.getApiKey())
                        .api_secret_key(userApi.getApiSecretKey())
                        .seller_id(userApi.getSellerId())
                        .api_type(userApi.getUserApiType())
                        .build()
                ).collect(Collectors.toList());
    }

    public UserApiTypes getUserApiTypes(Long userId) {
        return UserApiTypes.builder()
                .apiTypes(
                        userService.getUser(userId).getUserApis()
                        .stream()
                        .map(userApi -> userApi.getUserApiType())
                        .collect(Collectors.toList()))
                .build();
    }
}
