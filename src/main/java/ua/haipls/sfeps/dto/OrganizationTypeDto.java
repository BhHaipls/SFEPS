package ua.haipls.sfeps.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.Organization;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
public class OrganizationTypeDto  extends BaseDto{


    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{OrganizationTypeDto.name.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-ZА-ЯІ][A-Za-zА-Яа-яіІ\\- ]{1,48}",
            message = "{OrganizationTypeDto.name.pattern}")
    private String name;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{OrganizationTypeDto.description.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,512}",
            message = "{OrganizationTypeDto.description.pattern}")
    private String description;

    private int priority;

}
