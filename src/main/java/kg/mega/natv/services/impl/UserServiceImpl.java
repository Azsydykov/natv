package kg.mega.natv.services.impl;

import kg.mega.natv.dao.UserRep;
import kg.mega.natv.mappers.UserMapper;
import kg.mega.natv.models.dto.UserDto;
import kg.mega.natv.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserMapper userMapper = UserMapper.INSTANCE;

    private final UserRep userRep;

    @Override
    public UserDto save(UserDto t) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRep.findById(id).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    @Override
    public UserDto delete(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtos(userRep.findAll());
    }
}
