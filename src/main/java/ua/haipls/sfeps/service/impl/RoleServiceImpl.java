package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.dto.RoleDto;
import ua.haipls.sfeps.dto.mapper.RoleMapper;
import ua.haipls.sfeps.repositoriy.RoleRepository;
import ua.haipls.sfeps.service.RoleService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {


    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;



    @Override
    public RoleDto create(RoleDto roleDto) {

        Role role = roleMapper.toEntity(roleDto);
        RoleDto result = roleMapper.toDto(roleRepository.save(role));

        log.info("IN create - role: {} successfully created", result);

        return result;
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        findById(roleDto.getId());
        Role role = roleMapper.toEntity(roleDto);
        RoleDto result = roleMapper.toDto(roleRepository.save(role));
        log.info("IN update - role: {} successfully updated", result);

        return result;
    }

    @Override
    public Collection<RoleDto> findAll() {
        Collection<RoleDto> result = roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} roles found", result.size());
        return result;
    }

    @Override
    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found by id: " + id));
        RoleDto result = roleMapper.toDto(role);
        log.info("IN findById - role: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public RoleDto findByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found by name: " + name));
        RoleDto result = roleMapper.toDto(role);
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
