package org.sourpy.ecomapp.Dto.Trendyol.ListRequest;

import lombok.Data;

import java.util.List;

@Data
public class ProductTrendyol {
    boolean approved;
    boolean archived;
    List<ProductTrendyolAttributes> attributes;
    String barcode;
    String batchRequestId;
    String brand;
    int brandId;
    String categoryName;
    long createDateTime; //time
    String description;
    int dimensionalWeight;
    String gender;
    boolean hasActiveCampaign;
    String id;
    List<ProductTrendyolImage> images;
    long lastPriceChangeDate; //t
    long lastStockChangeDate;
    long lastUpdateDate;
    int listPrice;
    String lockReason;
    boolean locked;
    boolean onSale;
    int pimCategoryId;
    String platformListingId;
    int productCode;
    int productContentId;
    String productMainId;
    int quantity;
    int salePrice;
    int shipmentAddressId;
    String stockCode;
    String stockId;
    String stockUnitType;
    int supplierId;
    String title;
    int vatRate;
    int version;
    boolean rejected;
    String[] rejectReasonDetails;
    boolean blacklisted;
    String blacklistReason;
}