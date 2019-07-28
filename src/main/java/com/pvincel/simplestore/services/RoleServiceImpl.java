package com.pvincel.simplestore.services;

import com.pvincel.simplestore.model.Role;
import com.pvincel.simplestore.model.RoleName;
import com.pvincel.simplestore.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }
}
