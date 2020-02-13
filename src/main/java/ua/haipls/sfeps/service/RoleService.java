package ua.haipls.sfeps.service;

import ua.haipls.sfeps.domain.Role;

import java.util.Collection;

public interface RoleService {

    Role create(Role role);

    Role update(Role role);

    Collection<Role> findAll();

    Role findById(Long id);

    Role findByName(String name);

    void deleteById(Long id);
}
