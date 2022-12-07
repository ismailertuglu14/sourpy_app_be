package org.sourpy.ecomapp.Dto;

import lombok.Builder;
import lombok.Data;
import org.sourpy.ecomapp.Entity.UserApiType;

@Data
@Builder
public class UserApiResponse {
    private String api_key;
    private UserApiType api_type;
}
