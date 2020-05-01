package ua.haipls.sfeps.dto.mapper;

import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.User;
import ua.haipls.sfeps.dto.UserDto;
import ua.haipls.sfeps.dto.UserRegisterDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
    UserDto toDto(UserRegisterDto dto);
}
