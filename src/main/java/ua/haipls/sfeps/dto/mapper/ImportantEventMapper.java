package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.ImportantEvent;
import ua.haipls.sfeps.dto.ImportantEventDto;

@Mapper(componentModel = "spring")
public interface ImportantEventMapper {

    ImportantEvent toEntity(ImportantEventDto dto);

    ImportantEventDto toDto(ImportantEvent entity);
}
