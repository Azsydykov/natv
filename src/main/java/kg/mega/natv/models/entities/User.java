package kg.mega.natv.models.entities;

import kg.mega.natv.models.enums.Role;
import kg.mega.natv.models.enums.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
