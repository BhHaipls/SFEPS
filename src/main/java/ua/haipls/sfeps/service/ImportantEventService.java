package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.ImportantEventDto;

import java.util.Collection;

public interface ImportantEventService {

    ImportantEventDto create(ImportantEventDto importantEventDto);

    ImportantEventDto update(ImportantEventDto importantEventDto);

    Collection<ImportantEventDto> findAll();

    ImportantEventDto findById(Long id);

    void deleteById(Long id);
}
