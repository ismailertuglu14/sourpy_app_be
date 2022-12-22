package org.sourpy.ecomapp.Dto.Trendyol.ListResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrendyolListResponse {
    int productCode;
    int pimCategoryId;
}
