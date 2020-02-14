package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.EventDto;

import java.time.LocalDateTime;
import java.util.Collection;

public interface EventService {

    EventDto create(EventDto eventDto);

    EventDto update(EventDto eventDto);

    Collection<EventDto> findAll();

    EventDto findById(Long id);

    Collection<EventDto> findAllByAuthorId(Long id);

    Collection<EventDto> findAllByImportantId(Long id);

    Collection<EventDto> findAllByStatus(String status);

    Collection<EventDto> findAllByDateBetween(LocalDateTime start, LocalDateTime end);

    void deleteById(Long id);
}
