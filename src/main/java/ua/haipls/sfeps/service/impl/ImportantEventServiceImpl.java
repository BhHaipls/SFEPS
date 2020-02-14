package ua.haipls.sfeps.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.ImportantEvent;
import ua.haipls.sfeps.dto.ImportantEventDto;
import ua.haipls.sfeps.dto.mapper.ImportantEventMapper;
import ua.haipls.sfeps.repositoriy.ImportantEventRepository;
import ua.haipls.sfeps.service.ImportantEventService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImportantEventServiceImpl implements ImportantEventService {

    private final ImportantEventRepository importantEventRepository;
    private final ImportantEventMapper importantEventMapper;

    @Autowired
    public ImportantEventServiceImpl(ImportantEventRepository importantEventRepository, ImportantEventMapper importantEventMapper) {
        this.importantEventRepository = importantEventRepository;
        this.importantEventMapper = importantEventMapper;
    }

    @Override
    public ImportantEventDto create(ImportantEventDto importantEventDto) {
        ImportantEvent importantEvent = importantEventMapper.toEntity(importantEventDto);
        ImportantEvent result = importantEventRepository.save(importantEvent);

        ImportantEventDto resultDto = importantEventMapper.toDto(result);

        log.info("IN create - user: {} successfully created", resultDto);

        return resultDto;
    }

    @Override
    public ImportantEventDto update(ImportantEventDto importantEventDto) {
        findById(importantEventDto.getId());

        ImportantEvent result = importantEventRepository.save(importantEventMapper.toEntity(importantEventDto));
        ImportantEventDto resultDto = importantEventMapper.toDto(result);
        log.info("IN update - result: {} successfully updated", resultDto);

        return resultDto;
    }

    @Override
    public Collection<ImportantEventDto> findAll() {
        Collection<ImportantEventDto> result = ((Collection<ImportantEvent>) importantEventRepository.findAll())
                .stream()
                .map(importantEventMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} ImportantEvent found", result.size());
        return result;
    }

    @Override
    public ImportantEventDto findById(Long id) {
        ImportantEventDto result = importantEventMapper.toDto(importantEventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ImportantEvent not found by id: " + id)));
        log.info("IN findById - ImportantEvent: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        importantEventRepository.deleteById(id);
        log.info("IN deleteById - importantEvent with id: {} successfully deleted", id);
    }
}
