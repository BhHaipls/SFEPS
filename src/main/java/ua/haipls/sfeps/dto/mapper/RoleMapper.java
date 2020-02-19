package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.dto.RoleDto;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDto dto);

    RoleDto toDto(Role entity);

}
