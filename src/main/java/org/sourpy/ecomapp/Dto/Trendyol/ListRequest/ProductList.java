package org.sourpy.ecomapp.Dto.Trendyol.ListRequest;

import lombok.Data;

import java.util.List;

@Data
public class ProductList {
    int page;
    int size;
    int totalElements;
    int totalPages;
    List<ProductTrendyol> content;
}
