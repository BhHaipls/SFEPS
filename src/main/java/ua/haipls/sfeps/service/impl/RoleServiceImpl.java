package ua.haipls.sfeps.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.repositoriy.RoleRepository;
import ua.haipls.sfeps.service.RoleService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {

        Role result = roleRepository.save(role);

        log.info("IN create - role: {} successfully created", result);

        return result;
    }

    @Override
    public Role update(Role role) {
        findById(role.getId());

        Role result = roleRepository.save(role);
        log.info("IN update - role: {} successfully updated", result);

        return result;
    }

    @Override
    public Collection<Role> findAll() {
        Collection<Role> result = roleRepository.findAll();
        log.info("IN findAll - {} roles found", result.size());
        return result;
    }

    @Override
    public Role findById(Long id) {
        Role result = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found by id: " + id));
        log.info("IN findById - role: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public Role findByName(String name) {
        Role result = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found by name: " + name));
        log.info("IN findById - role: {} found by name: {}", result, name);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleRepository.deleteById(id);
        log.info("IN deleteById - role with id: {} successfully deleted", id);
    }
}
