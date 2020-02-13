package ua.haipls.sfeps.service.impl;

import org.springframework.stereotype.Service;
import ua.haipls.sfeps.dto.OrganizationDto;
import ua.haipls.sfeps.service.OrganizationService;

import java.util.Collection;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        return null;
    }

    @Override
    public OrganizationDto update(OrganizationDto organizationDto) {
        return null;
    }

    @Override
    public Collection<OrganizationDto> findAll() {
        return null;
    }

    @Override
    public Collection<OrganizationDto> findAllByAuthorId(Long id) {
        return null;
    }

    @Override
    public Collection<OrganizationDto> findAllByServiceTypeId(Long id) {
        return null;
    }

    @Override
    public OrganizationDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
