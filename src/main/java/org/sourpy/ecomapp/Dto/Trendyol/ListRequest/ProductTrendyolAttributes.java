package org.sourpy.ecomapp.Dto.Trendyol.ListRequest;

import lombok.Data;

@Data
public class ProductTrendyolAttributes {
    int attributeId;
    String attributeName;
    String attributeValue;
    int attributeValueId;
}