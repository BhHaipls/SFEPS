package ua.haipls.sfeps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.EventStatus;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class EventDto extends BaseDto {

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.name.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{4,90}",
            message = "{EventDto.name.pattern}")
    private String name;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.description.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,2054}",
            message = "{EventDto.description.pattern}")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-SS")
    private LocalDateTime date;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.address.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,256}",
            message = "{EventDto.address.pattern}")
    private String address;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.status.notnull}")
    private EventStatus status;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.important.notnull}")
    private ImportantEventDto important;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{EventDto.author.notnull}")
    private UserDto author;

}
