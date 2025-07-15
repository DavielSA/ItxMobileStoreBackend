package com.itxmobilestore.cashFlow.mapper;

import com.itxmobilestore.cashFlow.model.entity.CashFlow;
import com.itxmobilestore.cashFlow.model.request.CashFlowRequest;
import com.itxmobilestore.cashFlow.model.response.CashFlowResponse;
import com.itxmobilestore.productRelated.model.response.ProductResponse;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:51+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class CashFlowMapperImpl implements CashFlowMapper {

    @Override
    public CashFlowResponse cashFlowToCashFlowResponse(CashFlow entity) {
        if ( entity == null ) {
            return null;
        }

        CashFlowResponse cashFlowResponse = new CashFlowResponse();

        cashFlowResponse.setCurrency( entity.getCurrency() );
        cashFlowResponse.setId( entity.getId() );
        cashFlowResponse.setConcept( entity.getConcept() );
        cashFlowResponse.setDescription( entity.getDescription() );
        cashFlowResponse.setAmount( entity.getAmount() );
        cashFlowResponse.setCreatedAt( entity.getCreatedAt() );
        cashFlowResponse.setLastUpdateAt( entity.getLastUpdateAt() );
        cashFlowResponse.setBank( entity.getBank() );
        cashFlowResponse.setCategory( categoryToCategoryResponse( entity.getCategory() ) );
        cashFlowResponse.setDate( entity.getDate() );
        cashFlowResponse.setMovement( entity.getMovement() );

        return cashFlowResponse;
    }

    @Override
    public CashFlow requestToCashFlow(CashFlowRequest request) {
        if ( request == null ) {
            return null;
        }

        CashFlow cashFlow = new CashFlow();

        if ( request.bank() != null ) {
            cashFlow.setBank( request.bank() );
        }
        if ( request.date() != null ) {
            cashFlow.setDate( request.date() );
        }
        if ( request.concept() != null ) {
            cashFlow.setConcept( request.concept() );
        }
        if ( request.movement() != null ) {
            cashFlow.setMovement( request.movement() );
        }
        if ( request.amount() != null ) {
            cashFlow.setAmount( request.amount() );
        }
        if ( request.currency() != null ) {
            cashFlow.setCurrency( request.currency() );
        }
        if ( request.description() != null ) {
            cashFlow.setDescription( request.description() );
        }

        return cashFlow;
    }

    protected ProductResponse categoryToCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        String code = null;

        id = category.getId();
        name = category.getName();
        description = category.getDescription();
        code = category.getCode();

        ProductResponse productResponse = new ProductResponse( id, name, code, description );

        return productResponse;
    }
}
