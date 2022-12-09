package org.sourpy.ecomapp.Dto;

import lombok.Builder;
import lombok.Data;
import org.sourpy.ecomapp.Entity.UserApiType;

@Data
@Builder
public class UserApiResponse {
    private String api_key;
    private String api_secret_key;
    private String seller_id;
    private UserApiType api_type;
}
