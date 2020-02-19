package ua.haipls.sfeps.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
public class ImportantEventDto  extends BaseDto{
    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{ImportantEventDto.name.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,48}",
            message = "{ImportantEventDto.name.pattern}")
    private String name;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{ImportantEventDto.description.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,512}",
            message = "{ImportantEventDto.description.pattern}")
    private String description;

    private int priority;

}
