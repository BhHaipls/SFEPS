package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.OrganizationType;
import ua.haipls.sfeps.dto.OrganizationTypeDto;

@Mapper(componentModel = "spring")
public interface OrganizationTypeMapper {

    OrganizationType toEntity(OrganizationTypeDto dto);

    OrganizationTypeDto toDto(OrganizationType entity);
}
