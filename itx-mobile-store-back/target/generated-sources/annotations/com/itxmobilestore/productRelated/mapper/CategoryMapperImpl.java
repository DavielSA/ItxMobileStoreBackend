package com.itxmobilestore.productRelated.mapper;

import com.itxmobilestore.productRelated.model.request.CategoryRequest;
import com.itxmobilestore.productRelated.model.response.ProductResponse;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:52+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public ProductResponse categoryToCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        String code = null;

        if ( category.getId() != null ) {
            id = category.getId();
        }
        if ( category.getName() != null ) {
            name = category.getName();
        }
        if ( category.getDescription() != null ) {
            description = category.getDescription();
        }
        if ( category.getCode() != null ) {
            code = category.getCode();
        }

        ProductResponse productResponse = new ProductResponse( id, name, code, description );

        return productResponse;
    }

    @Override
    public Category categoryRequestToCategory(CategoryRequest categoryRequest) {
        if ( categoryRequest == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryRequest.name() );
        category.setCode( categoryRequest.code() );
        category.setDescription( categoryRequest.description() );

        return category;
    }
}
