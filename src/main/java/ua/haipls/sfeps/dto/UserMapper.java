package ua.haipls.sfeps.dto;

import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
