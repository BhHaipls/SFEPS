package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Organization;
import ua.haipls.sfeps.dto.OrganizationDto;
import ua.haipls.sfeps.dto.mapper.OrganizationMapper;
import ua.haipls.sfeps.repositoriy.OrganizationRepository;
import ua.haipls.sfeps.service.OrganizationService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;



    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = organizationMapper.toEntity(organizationDto);
        OrganizationDto result = organizationMapper.toDto(organizationRepository.save(organization));

        log.info("IN create - organiztion: {} successfully created", result);

        return result;
    }

    @Override
    public OrganizationDto update(OrganizationDto organizationDto) {

        findById(organizationDto.getId());

        Organization organization = organizationMapper.toEntity(organizationDto);
        OrganizationDto result = organizationMapper.toDto(organizationRepository.save(organization));

        log.info("IN update - organiztion: {} successfully updated", result);

        return result;
    }

    @Override
    public Collection<OrganizationDto> findAll() {
        Collection<OrganizationDto> result = ((Collection<Organization>) organizationRepository.findAll())
                .stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} Organization found", result.size());
        return result;
    }

    @Override
    public Collection<OrganizationDto> findAllByAuthorId(Long id) {
        Collection<OrganizationDto> result = organizationRepository.findAllByAuthorId(id)
                .stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByAuthorId ({}) - {} Organization found",id, result.size());
        return result;
    }

    @Override
    public Collection<OrganizationDto> findAllByOrganizationTypeId(Long id) {
        Collection<OrganizationDto> result = organizationRepository.findAllByOrganizationTypeId(id)
                .stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByServiceTypeId ({})- {} Organization found", id,result.size());
        return result;
    }

    @Override
    public OrganizationDto findById(Long id) {
        OrganizationDto result = organizationMapper.toDto(organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found by id: " + id)));
        log.info("IN findById - Organization: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        organizationRepository.deleteById(id);
        log.info("IN deleteById - Organization with id: {} successfully deleted", id);

    }
}
