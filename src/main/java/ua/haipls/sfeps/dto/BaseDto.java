package ua.haipls.sfeps.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BaseDto {

    @Null(groups = {OnCreate.class}, message = "{baseDto.id.null}")
    @NotNull(groups = {OnUpdate.class}, message = "{baseDto.id.notnull}")
    private Long id;

}
