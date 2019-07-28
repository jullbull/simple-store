package com.pvincel.simplestore.services;

import com.pvincel.simplestore.model.Role;
import com.pvincel.simplestore.model.RoleName;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(RoleName roleName);

}
