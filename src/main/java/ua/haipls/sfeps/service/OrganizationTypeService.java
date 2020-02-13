package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.OrganizationTypeDto;

import java.util.Collection;

public interface OrganizationTypeService {

    OrganizationTypeDto create(OrganizationTypeDto organizationTypeDto);

    OrganizationTypeDto update(OrganizationTypeDto organizationTypeDto);

    Collection<OrganizationTypeDto> findAll();

    OrganizationTypeDto findById(Long id);

    void deleteById(Long id);
}
