package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.Trendyol.ListResponse.TrendyolListResponse;
import org.sourpy.ecomapp.Service.TrendyolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trendyol")
@AllArgsConstructor
public class TrendyolController {
    private TrendyolService trendyolService;

    @GetMapping("/products")
    public ResponseEntity<List<TrendyolListResponse>> getProductList(){
        return trendyolService.getProductList();
    }
}
