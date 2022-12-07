package org.sourpy.ecomapp.Dto;

import lombok.Data;

@Data
public class UserCreateDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
