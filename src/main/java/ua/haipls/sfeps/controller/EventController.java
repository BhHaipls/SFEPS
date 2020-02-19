package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.dto.EventDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.EventService;

import java.time.LocalDateTime;
import java.util.Collection;


@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto create(@Validated(OnCreate.class) @RequestBody EventDto eventDto) {
        return eventService.create(eventDto);
    }

    @PutMapping("/{id}")
    public EventDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody EventDto eventDto) {
        eventDto.setId(id);
        return eventService.update(eventDto);
    }

    @GetMapping
    public Collection<EventDto> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public EventDto findById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @GetMapping("/author/{id}")
    public Collection<EventDto> findByAuthorId(@PathVariable Long id) {
        return eventService.findAllByAuthorId(id);
    }

    @GetMapping("/status/{id}")
    public Collection<EventDto> findAllByStatus(@PathVariable String status) {
        return eventService.findAllByStatus(status);
    }

    @GetMapping("/")
    public Collection<EventDto> findAllByDateBetween(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return eventService.findAllByDateBetween(start, end);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        eventService.deleteById(id);
    }
}