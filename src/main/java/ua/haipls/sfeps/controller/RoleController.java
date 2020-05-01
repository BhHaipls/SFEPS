package ua.haipls.sfeps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.dto.RoleDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.RoleService;

import java.util.Collection;


@RestController
@RequestMapping("/users/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDto create(@Validated(OnCreate.class) @RequestBody RoleDto role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    public RoleDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody RoleDto role) {
        role.setId(id);
        return roleService.update(role);
    }

    @GetMapping
    public Collection<RoleDto> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping("/")
    public RoleDto findByName(@RequestParam  String name) {return roleService.findByName(name);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }


}