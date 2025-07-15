package com.itxmobilestore.role.mapper;

import com.itxmobilestore.role.model.entity.Role;
import com.itxmobilestore.role.model.request.RoleRequest;
import com.itxmobilestore.role.model.response.RoleResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:51+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResponse roleToRoleResponse(Role role) {
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

    @Override
    public Role roleRequestToRole(RoleRequest roleRequest) {
        if ( roleRequest == null ) {
            return null;
        }

        Role role = new Role();

        return role;
    }
}
