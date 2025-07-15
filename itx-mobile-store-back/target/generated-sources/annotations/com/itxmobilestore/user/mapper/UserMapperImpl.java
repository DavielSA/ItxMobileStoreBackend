package com.itxmobilestore.user.mapper;

import com.itxmobilestore.address.model.entity.Address;
import com.itxmobilestore.address.model.response.AddressResponse;
import com.itxmobilestore.role.model.entity.Role;
import com.itxmobilestore.role.model.response.RoleResponse;
import com.itxmobilestore.user.model.entity.Users;
import com.itxmobilestore.user.model.request.UserRequest;
import com.itxmobilestore.user.model.response.UserResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:52+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse userToUserResponse(Users users) {
        if ( users == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( users.getId() );
        userResponse.setUsername( users.getUsername() );
        userResponse.setEmail( users.getEmail() );
        userResponse.setPassword( users.getPassword() );
        userResponse.setRole( roleToRoleResponse( users.getRole() ) );
        userResponse.setAddresses( addressListToAddressResponseList( users.getAddresses() ) );
        userResponse.setCreatedAt( users.getCreatedAt() );
        userResponse.setUpdatedAt( users.getUpdatedAt() );

        return userResponse;
    }

    @Override
    public Users userRequestToUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        Users users = new Users();

        if ( userRequest.username() != null ) {
            users.setUsername( userRequest.username() );
        }
        if ( userRequest.email() != null ) {
            users.setEmail( userRequest.email() );
        }
        if ( userRequest.password() != null ) {
            users.setPassword( userRequest.password() );
        }

        return users;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = role.getId();
        name = role.getName();

        String description = null;

        RoleResponse roleResponse = new RoleResponse( id, name, description );

        return roleResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
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

    protected List<AddressResponse> addressListToAddressResponseList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressResponse> list1 = new ArrayList<AddressResponse>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressResponse( address ) );
        }

        return list1;
    }
}
