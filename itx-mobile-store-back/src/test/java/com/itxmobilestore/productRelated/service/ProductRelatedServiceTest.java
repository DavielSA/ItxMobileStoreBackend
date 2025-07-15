package com.itxmobilestore.productRelated.service;

import com.itxmobilestore.productRelated.client.ProductClient;
import com.itxmobilestore.productRelated.model.response.ProductResponse;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductRelatedServiceTest {

    @Mock
    private ProductClient productClient;
    @InjectMocks
    private ProductRelatedService productRelatedService;

    @Test
    void getProductRelated_ShouldReturnProductList_WhenAllCallsSucceed() {
        Long inputId = 1L;
        List<Long> similarIds = List.of(2L, 3L);
        ProductResponse product2 = new ProductResponse(2L, "Product 2", 100L, true);
        ProductResponse product3 = new ProductResponse(3L, "Product 3",  200L, true);
        when(productClient.getSimilarIds(inputId)).thenReturn(similarIds);
        when(productClient.getProductById(2L)).thenReturn(product2);
        when(productClient.getProductById(3L)).thenReturn(product3);
        List<ProductResponse> result = productRelatedService.getProductRelated(inputId);
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of(product2, product3)));
    }

    @Test
    void getProductRelated_ShouldSkipProduct_WhenFeignExceptionOccurs() {
        Long inputId = 1L;
        List<Long> similarIds = List.of(2L, 3L);
        ProductResponse product2 = new ProductResponse(2L, "Product 2", 100L, true);
        when(productClient.getSimilarIds(inputId)).thenReturn(similarIds);
        when(productClient.getProductById(2L)).thenReturn(product2);
        when(productClient.getProductById(3L)).thenThrow(FeignException.NotFound.class);
        List<ProductResponse> result = productRelatedService.getProductRelated(inputId);
        assertEquals(1, result.size());
        assertEquals(product2, result.get(0));
    }

    @Test
    void getProductRelated_ShouldReturnEmptyList_WhenNoSimilarProducts() {
        Long inputId = 1L;
        when(productClient.getSimilarIds(inputId)).thenReturn(Collections.emptyList());
        List<ProductResponse> result = productRelatedService.getProductRelated(inputId);
        assertTrue(result.isEmpty());
    }

}
