package ua.haipls.sfeps;

import ua.haipls.sfeps.domain.domainEnum.UserStatus;
import ua.haipls.sfeps.dto.ImportantEventDto;
import ua.haipls.sfeps.dto.UserDto;

import java.time.LocalDate;

public interface DtoDirector {

    static UserDto makeTestUserDtoById(Long id) {
        return UserDto.builder()
                .id(id)
                .firstName("User")
                .secondName("User")
                .dateBirth(LocalDate.of(2000, 12, 17))
                .email("user" + id + "@gmail.com")
                .password("userPassword")
                .roles(null)
                .status(UserStatus.ACTIVATED)
                .build();
    }
    static ImportantEventDto makeTestImportantEventDtoById(Long id) {
        return ImportantEventDto.builder()
                .id(id)
                .name("Important")
                .priority(10)
                .description("Very important event")
                .build();
    }
}
