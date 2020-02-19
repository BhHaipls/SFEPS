package ua.haipls.sfeps.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.OrganizationStatus;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
public class OrganizationDto extends BaseDto {
    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{OrganizationDto.name.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{3,200}",
            message = "{OrganizationDto.name.pattern}")
    private String name;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{OrganizationDto.description.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,1024}",
            message = "{OrganizationDto.description.pattern}")
    private String description;

    @NotNull(groups = { OnUpdate.class},
            message = "{OrganizationDto.status.notnull}")
    private OrganizationStatus organizationStatus;

    @NotNull(groups = { OnUpdate.class},
            message = "{OrganizationDto.type.notnull}")
    private OrganizationTypeDto organizationType;

    private int rating;

}
