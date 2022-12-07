package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.ApiCreateDto;
import org.sourpy.ecomapp.Entity.Api;
import org.sourpy.ecomapp.Service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @PostMapping
    public ResponseEntity<Api> createApi(@RequestBody ApiCreateDto apiInfo){
        return ResponseEntity.ok(apiService.createApi(apiInfo));
    }
}
