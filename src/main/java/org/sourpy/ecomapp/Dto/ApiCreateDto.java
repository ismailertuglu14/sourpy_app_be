package org.sourpy.ecomapp.Dto;

import lombok.Data;
import org.sourpy.ecomapp.Entity.ApiType;

@Data
public class ApiCreateDto {
    private String api_key;
    private ApiType api_type;
    private Long user_id;
}
