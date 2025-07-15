package com.itxmobilestore.address.mapper;

import com.itxmobilestore.address.model.entity.Address;
import com.itxmobilestore.address.model.request.AddressRequest;
import com.itxmobilestore.address.model.response.AddressResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:52+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        Long id = null;
        String street = null;
        String city = null;
        String state = null;
        String postalCode = null;
        String country = null;

        id = address.getId();
        street = address.getStreet();
        city = address.getCity();
        state = address.getState();
        postalCode = address.getPostalCode();
        country = address.getCountry();

        String createdAt = null;
        String lastUpdatedAt = null;

        AddressResponse addressResponse = new AddressResponse( id, street, city, state, postalCode, country, createdAt, lastUpdatedAt );

        return addressResponse;
    }

    @Override
    public Address addressRequestToAddress(AddressRequest addressRequest) {
        if ( addressRequest == null ) {
            return null;
        }

        String street = null;
        String city = null;
        String country = null;

        if ( addressRequest.street() != null ) {
            street = addressRequest.street();
        }
        if ( addressRequest.city() != null ) {
            city = addressRequest.city();
        }
        if ( addressRequest.country() != null ) {
            country = addressRequest.country();
        }

        String postalCode = null;

        Address address = new Address( street, city, country, postalCode );

        if ( addressRequest.state() != null ) {
            address.setState( addressRequest.state() );
        }

        return address;
    }
}
