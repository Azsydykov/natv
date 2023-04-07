package kg.mega.natv.mappers;


import kg.mega.natv.models.dto.UserDto;

import kg.mega.natv.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
