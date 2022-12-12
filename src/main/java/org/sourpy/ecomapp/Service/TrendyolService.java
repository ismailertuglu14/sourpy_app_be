package org.sourpy.ecomapp.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrendyolService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${trendyolURL}")
    private String baseURL;

    @Value("${yesilbilisim.sellerId}")
    private String sellerId;

    @Value("${yesilbilisim.api_key}")
    private String apiKey;

    @Value("${yesilbilisim.api_secret_key}")
    private String apiSecretKey;

    public ResponseEntity<String> getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(apiKey,apiSecretKey);
        headers.add("User-Agent",String.format("%s - SelfIntegration",sellerId));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(baseURL+"suppliers/"+sellerId+"/products", HttpMethod.GET,entity,String.class);
    }
}
