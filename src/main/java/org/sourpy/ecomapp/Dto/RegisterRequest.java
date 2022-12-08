package org.sourpy.ecomapp.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
