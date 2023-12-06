package com.pruebaTecnica.prevalentware.service.impl;

import com.pruebaTecnica.prevalentware.Mapper.RoleMapper;
import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.entity.RoleEntity;
import com.pruebaTecnica.prevalentware.repository.RoleRepository;
import com.pruebaTecnica.prevalentware.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto findById(String id) {
        Optional<RoleEntity> result = roleRepository.findById(id);
        return result.map(roleMapper::toRoleDto).orElse(null);
    }
}
