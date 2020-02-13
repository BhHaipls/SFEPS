package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.Event;
import ua.haipls.sfeps.dto.EventDto;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(EventDto dto);

    EventDto toDto(Event entity);
}
