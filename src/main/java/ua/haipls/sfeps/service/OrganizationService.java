package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.OrganizationDto;

import java.util.Collection;

public interface OrganizationService {

    OrganizationDto create(OrganizationDto organizationDto);

    OrganizationDto update(OrganizationDto organizationDto);

    Collection<OrganizationDto> findAll();

    Collection<OrganizationDto> findAllByAuthorId(Long id);

    Collection<OrganizationDto> findAllByServiceTypeId(Long id);

    OrganizationDto findById(Long id);

    void deleteById(Long id);
}
