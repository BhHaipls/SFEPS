package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.dto.ImportantEventDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.ImportantEventService;

import java.util.Collection;


@RestController
@RequestMapping("/events/types")
@RequiredArgsConstructor
public class ImportantEventController {

    private final ImportantEventService importantEventService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImportantEventDto create(@Validated(OnCreate.class) @RequestBody ImportantEventDto importantEventDto) {
        return importantEventService.create(importantEventDto);
    }

    @PutMapping("/{id}")
    public ImportantEventDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody ImportantEventDto role) {
        role.setId(id);
        return importantEventService.update(role);
    }

    @GetMapping
    public Collection<ImportantEventDto> findAll() {
        return importantEventService.findAll();
    }

    @GetMapping("/{id}")
    public ImportantEventDto findById(@PathVariable Long id) {
        return importantEventService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        importantEventService.deleteById(id);
    }

}