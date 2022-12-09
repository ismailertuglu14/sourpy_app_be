package org.sourpy.ecomapp.Dto;

import lombok.Builder;
import lombok.Data;
import org.sourpy.ecomapp.Entity.UserApiType;

import java.util.List;

@Builder
@Data
public class UserApiTypes {
    private List<UserApiType> apiTypes;
}
