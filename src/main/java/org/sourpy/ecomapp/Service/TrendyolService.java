package org.sourpy.ecomapp.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sourpy.ecomapp.Dto.Trendyol.ListRequest.ProductList;
import org.sourpy.ecomapp.Dto.Trendyol.ListResponse.TrendyolListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrendyolService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${trendyolURL}")
    private String baseURL;

    @Value("${yesilbilisim.sellerId}")
    private String sellerId;

    @Value("${yesilbilisim.api_key}")
    private String apiKey;

    @Value("${yesilbilisim.api_secret_key}")
    private String apiSecretKey;

    public ResponseEntity<List<TrendyolListResponse>> getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey,apiSecretKey);
        headers.add("User-Agent",String.format("%s - SelfIntegration",sellerId));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> json = restTemplate.exchange(baseURL+"suppliers/"+sellerId+"/products", HttpMethod.GET,entity, String.class);
        ProductList list = null;
        try {
            list = objectMapper.readValue(json.getBody(),ProductList.class);

        }catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(list.getContent()
                .stream()
                .map(productTrendyol -> TrendyolListResponse
                        .builder()
                        .title(productTrendyol.getTitle())
                        .salePrice(productTrendyol.getSalePrice())
                        .build()).collect(Collectors.toList()),HttpStatus.OK);
    }
}
