package org.sourpy.ecomapp.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginRequest {
    @Length(min = 4,message = "Username not valid.")
    private String username;
    @Length(min = 6,message = "Password not valid.")
    private String password;
}
