package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.dto.OrganizationTypeDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.OrganizationTypeService;

import java.util.Collection;

@RestController
@RequestMapping("/api/organizations/types")
@RequiredArgsConstructor
public class OrganizationTypeController {

    private final OrganizationTypeService organizationTypeService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationTypeDto create(@Validated(OnCreate.class) @RequestBody OrganizationTypeDto organizationTypeDto) {
        return organizationTypeService.create(organizationTypeDto);
    }

    @PutMapping("/{id}")
    public OrganizationTypeDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody OrganizationTypeDto role) {
        role.setId(id);
        return organizationTypeService.update(role);
    }

    @GetMapping
    public Collection<OrganizationTypeDto> findAll() {
        return organizationTypeService.findAll();
    }

    @GetMapping("/{id}")
    public OrganizationTypeDto findById(@PathVariable Long id) {
        return organizationTypeService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        organizationTypeService.deleteById(id);
    }

}
