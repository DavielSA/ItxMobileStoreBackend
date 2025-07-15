package com.itxmobilestore.productRelated.client;

import com.itxmobilestore.productRelated.model.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productClient", url = "http://localhost:3001")
public interface ProductClient {
    @GetMapping("/product/{productId}/similarids")
    List<Long> getSimilarIds(@PathVariable("productId") Long productId);

    @GetMapping("/product/{productId}")
    ProductResponse getProductById(@PathVariable("productId") Long productId);
}
