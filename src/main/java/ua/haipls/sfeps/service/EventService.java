package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.EventDto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface EventService {

    EventDto create(EventDto commentDto);

    EventDto update(EventDto commentDto);

    Collection<EventDto> findAll();

    EventDto findById(Long id);

    List<EventDto> findAllByAuthorId(Long id);

    List<EventDto> findAllByImportantId(Long id);

    List<EventDto> findAllByStatus(String status);

    List<EventDto> findAllByDateBetween(LocalDateTime start, LocalDateTime end);

    void deleteById(Long id);
}
