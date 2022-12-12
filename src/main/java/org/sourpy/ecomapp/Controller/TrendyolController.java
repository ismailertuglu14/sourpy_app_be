package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Service.TrendyolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trendyol")
@AllArgsConstructor
public class TrendyolController {
    private TrendyolService trendyolService;

    @GetMapping("/products")
    public ResponseEntity<String> getProductList(){
        return trendyolService.getProductList();
    }
}
