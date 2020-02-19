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
public class CommentDto extends BaseDto {

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{CommentDto.text.notnull}")
    @Pattern(groups = {OnCreate.class, OnUpdate.class},
            regexp = "[A-Za-zА-Яа-яіІ\\- ]{1,1024}",
            message = "{CommentDto.text.pattern}")
    private String text;

    private int rating;

    @NotNull(groups = {OnCreate.class, OnUpdate.class},
            message = "{CommentDto.author.notnull}")
    private UserDto author;

}
