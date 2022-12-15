package org.sourpy.ecomapp.Dto.Trendyol.ListResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrendyolListResponse {
    String title;
    int salePrice;
}
