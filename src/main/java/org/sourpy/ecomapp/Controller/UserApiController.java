package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.UserApiRequest;
import org.sourpy.ecomapp.Dto.UserApiResponse;
import org.sourpy.ecomapp.Dto.UserApiTypes;
import org.sourpy.ecomapp.Entity.UserApi;
import org.sourpy.ecomapp.Service.UserApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserApiController {
    private final UserApiService userApiService;

    @PostMapping
    public ResponseEntity<UserApi> createApi(@RequestBody UserApiRequest apiInfo){
        return new ResponseEntity<>(userApiService.createApi(apiInfo), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserApiResponse>> getUserApis(@PathVariable Long userId){
        return new ResponseEntity<>(userApiService.getUserApis(userId), HttpStatus.OK);
    }

    @GetMapping("/types/{userId}")
    public ResponseEntity<UserApiTypes> getUserApiTypes(@PathVariable Long userId){
        return new ResponseEntity<>(userApiService.getUserApiTypes(userId), HttpStatus.OK);
    }
}
