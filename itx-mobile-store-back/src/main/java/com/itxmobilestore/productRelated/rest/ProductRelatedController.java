package com.itxmobilestore.productRelated.rest;


import com.itxmobilestore.productRelated.model.response.ProductResponse;
import com.itxmobilestore.productRelated.service.ProductRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRelatedController {

    private final ProductRelatedService productRelatedService;

    @Autowired
    public ProductRelatedController(ProductRelatedService productRelatedService) {
        this.productRelatedService = productRelatedService;
    }

    @GetMapping("/{id}/related")
    public List<ProductResponse> getProductRelated(@PathVariable Long id) {
        return productRelatedService.getProductRelated(id);
    }

}
