package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.RoleDto;

import java.util.Collection;

public interface RoleService {

    RoleDto create(RoleDto roleDto);

    RoleDto update(RoleDto roleDto);

    Collection<RoleDto> findAll();

    RoleDto findById(Long id);

    RoleDto findByName(String name);

    void deleteById(Long id);
}
