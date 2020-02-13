package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.Organization;
import ua.haipls.sfeps.dto.OrganizationDto;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    Organization toEntity(OrganizationDto dto);

    OrganizationDto toDto(Organization entity);
}
