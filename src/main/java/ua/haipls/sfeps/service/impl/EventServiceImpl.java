package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Event;
import ua.haipls.sfeps.dto.EventDto;
import ua.haipls.sfeps.dto.mapper.EventMapper;
import ua.haipls.sfeps.repositoriy.EventRepository;
import ua.haipls.sfeps.service.EventService;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public EventDto create(EventDto eventDto) {

        Event event = eventMapper.toEntity(eventDto);

        Event result = eventRepository.save(event);

        EventDto resultDto = eventMapper.toDto(result);
        log.info("IN create - event: {} successfully created", resultDto);

        return resultDto;

    }

    @Override
    public EventDto update(EventDto eventDto) {

        findById(eventDto.getId());

        Event event = eventMapper.toEntity(eventDto);
        Event result = eventRepository.save(event);
        EventDto resultDto = eventMapper.toDto(result);
        log.info("IN update - event: {} successfully updated", resultDto);

        return resultDto;
    }

    @Override
    public Collection<EventDto> findAll() {
        Collection<EventDto> result = ((Collection<Event>) eventRepository.findAll())
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} event found", result.size());
        return result;
    }

    @Override
    public EventDto findById(Long id) {
        EventDto result = eventMapper.toDto(eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found by id: " + id)));
        log.info("IN findById - event: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public Collection<EventDto> findAllByAuthorId(Long id) {

        Collection<EventDto> result = eventRepository.findAllByAuthorId(id)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByAuthorId - id:{} - {} event found", id, result.size());
        return result;
    }

    @Override
    public Collection<EventDto> findAllByImportantId(Long id) {

        Collection<EventDto> result = eventRepository.findAllByImportantId(id)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByImportantId - id:{} - {} event found", id, result.size());
        return result;
    }

    @Override
    public Collection<EventDto> findAllByStatus(String status) {

        Collection<EventDto> result = eventRepository.findAllByStatus(status)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByStatus - status:{} - {} event found", status, result.size());
        return result;
    }

    @Override
    public Collection<EventDto> findAllByDateBetween(LocalDateTime start, LocalDateTime end) {

        Collection<EventDto> result = eventRepository.findAllByDateBetween(start, end)
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByDateBetween - ({} - {}) - {} event found", start, end, result.size());
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        eventRepository.deleteById(id);
        log.info("IN deleteById - event with id: {} successfully deleted", id);
    }
}
