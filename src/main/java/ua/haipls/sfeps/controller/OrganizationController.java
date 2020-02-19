package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.dto.OrganizationDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.OrganizationService;

import java.util.Collection;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDto create(@Validated(OnCreate.class) @RequestBody OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }

    @PutMapping("/{id}")
    public OrganizationDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody OrganizationDto organizationDto) {
        organizationDto.setId(id);
        return organizationService.update(organizationDto);
    }

    @GetMapping
    public Collection<OrganizationDto> findAll() {
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public OrganizationDto findById(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    @GetMapping("/author/{id}")
    public Collection<OrganizationDto> findByAuthorId(@PathVariable Long id) {
        return organizationService.findAllByAuthorId(id);
    }

    @GetMapping("/type/{id}")
    public Collection<OrganizationDto> findAllByOrganizationTypeId(@PathVariable Long id) {
        return organizationService.findAllByOrganizationTypeId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        organizationService.deleteById(id);
    }
}