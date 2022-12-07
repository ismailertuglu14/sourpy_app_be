package org.sourpy.ecomapp.Service;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.ApiCreateDto;
import org.sourpy.ecomapp.Entity.Api;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Exception.UserNotFoundException;
import org.sourpy.ecomapp.Repository.ApiRepostiory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApiService {
    private final ApiRepostiory apiRepostiory;
    private final UserService userService;

    public Api createApi(ApiCreateDto apiInfo) {
        User user = userService.getUserById(apiInfo.getUser_id());
        return apiRepostiory.save(Api.builder()
                .apiKey(apiInfo.getApi_key())
                .user(user)
                .apiType(apiInfo.getApi_type())
                .build()
        );
    }
}
