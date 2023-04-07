package kg.mega.natv.models.dto;


import kg.mega.natv.models.enums.Role;
import kg.mega.natv.models.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    String fio;
    @Enumerated(EnumType.STRING)
    Role role;
    String login;
    String email;
    String phone;
    String password;
    @Enumerated(EnumType.STRING)
    UserStatus userStatus;

}
