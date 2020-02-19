package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.OrganizationType;
import ua.haipls.sfeps.dto.OrganizationTypeDto;
import ua.haipls.sfeps.dto.mapper.OrganizationTypeMapper;
import ua.haipls.sfeps.repositoriy.OrganizationTypeRepository;
import ua.haipls.sfeps.service.OrganizationTypeService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrganizationTypeServiceImpl implements OrganizationTypeService {

    private final OrganizationTypeMapper organizationTypeMapper;
    private final OrganizationTypeRepository organizationTypeRepository;


    @Override
    public OrganizationTypeDto create(OrganizationTypeDto organizationTypeDto) {
        OrganizationType user = organizationTypeRepository.save(organizationTypeMapper.toEntity(organizationTypeDto));
        OrganizationTypeDto result = organizationTypeMapper.toDto(user);

        log.info("IN create - organization type: {} successfully created", result);

        return result;
    }

    @Override
    public OrganizationTypeDto update(OrganizationTypeDto organizationTypeDto) {
        findById(organizationTypeDto.getId());
        OrganizationType user = organizationTypeRepository.save(organizationTypeMapper.toEntity(organizationTypeDto));
        OrganizationTypeDto result = organizationTypeMapper.toDto(user);

        log.info("IN update - organization type: {} successfully updated", result);

        return result;
    }

    @Override
    public Collection<OrganizationTypeDto> findAll() {
        Collection<OrganizationTypeDto> result = ((Collection<OrganizationType>) organizationTypeRepository.findAll())
                .stream()
                .map(organizationTypeMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} organization type found", result.size());
        return result;
    }

    @Override
    public OrganizationTypeDto findById(Long id) {
        OrganizationTypeDto result = organizationTypeMapper.toDto(organizationTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization type not found by id: " + id)));
        log.info("IN findById - organization type: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        organizationTypeRepository.deleteById(id);
        log.info("IN deleteById - organization type with id: {} successfully deleted", id);
    }
}
