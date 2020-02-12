package ua.haipls.sfeps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.domain.domainEnum.UserStatus;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@SuperBuilder
public class UserDto extends BaseDto {
    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{userDto.firstName.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-ZА-ЯІ][A-Za-zА-Яа-яіІ\\- ]{2,30}",
            message = "{userDto.firstName.pattern}")
    private String firstName;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{userDto.secondName.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-ZА-ЯІ][A-Za-zА-Яа-яіІ\\- ]{2,30}",
            message = "{userDto.secondName.pattern}")
    private String secondName;

    @NotBlank(groups = {OnCreate.class},
            message = "{userDto.email.notblank}")
    @Email(groups = {OnCreate.class},
            message = "{userDto.email.email}")
    private String email;

    @NotNull(groups = {OnCreate.class},
            message = "{userDto.password.notnull}")
    @Size(groups = {OnCreate.class},
            min = 6, max = 32,
            message = "{userDto.password.size}")
    private String password;

    @Past(groups = {OnCreate.class, OnUpdate.class}, message = "{userDto.dateBirth.past}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate dateBirth;

    @NotEmpty(groups = {OnUpdate.class}, message = "{userDto.roles.notempty}")
    private Set<Role> roles;

    private UserStatus status;

}
