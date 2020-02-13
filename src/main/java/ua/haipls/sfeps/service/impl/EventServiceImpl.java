package ua.haipls.sfeps.service.impl;

import org.springframework.stereotype.Service;
import ua.haipls.sfeps.dto.EventDto;
import ua.haipls.sfeps.service.EventService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public EventDto create(EventDto commentDto) {
        return null;
    }

    @Override
    public EventDto update(EventDto commentDto) {
        return null;
    }

    @Override
    public Collection<EventDto> findAll() {
        return null;
    }

    @Override
    public EventDto findById(Long id) {
        return null;
    }

    @Override
    public List<EventDto> findAllByAuthorId(Long id) {
        return null;
    }

    @Override
    public List<EventDto> findAllByImportantId(Long id) {
        return null;
    }

    @Override
    public List<EventDto> findAllByStatus(String status) {
        return null;
    }

    @Override
    public List<EventDto> findAllByDateBetween(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
