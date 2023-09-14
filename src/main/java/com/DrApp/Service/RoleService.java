package com.DrApp.Service;

import com.DrApp.Model.Role;
import com.DrApp.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(Role theRole) {
        roleRepository.save(theRole);
    }
}
