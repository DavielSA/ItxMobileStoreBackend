package com.itxmobilestore.productRelated.service;

import com.itxmobilestore.productRelated.client.ProductClient;
import com.itxmobilestore.productRelated.model.response.ProductResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductRelatedService {

    private final Logger Log = LoggerFactory.getLogger(ProductRelatedService.class);
    private final ProductClient productClient;

    @Autowired
    public ProductRelatedService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<ProductResponse> getProductRelated(Long id) {
        List<Long> similarIdProducts = productClient.getSimilarIds(id);

        List<ProductResponse> responses = similarIdProducts.stream()
                .map(this::findAndGenerateList)
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());

        return responses;
    }


    private ProductResponse findAndGenerateList(Long productId) {
        try {
            return productClient.getProductById(productId);
        } catch (FeignException e) {
            Log.error(e.getMessage());
            return null;
        }
    }

}
