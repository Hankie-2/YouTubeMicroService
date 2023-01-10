package kg.charginov.userservice.service.impl;

import jakarta.ws.rs.NotFoundException;
import kg.charginov.userservice.exception.UserNotFoundException;
import kg.charginov.userservice.model.dto.UserDto;
import kg.charginov.userservice.model.dto.UserRequest;
import kg.charginov.userservice.model.entity.User;
import kg.charginov.userservice.model.mapper.UserMapper;
import kg.charginov.userservice.repository.UserRepository;
import kg.charginov.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserDto> findAll() {
        return UserMapper.INSTANCE
                .toDtoList(repository.findAll());
    }

    @Override
    public UserDto findUserById(Long id) {
        return UserMapper.INSTANCE
                .toDto(repository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("Нет такого пользователя с ID '" + id + "'",404)));
    }

    @Override
    public UserDto save(UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        return UserMapper.INSTANCE
                .toDto(repository.save(user));
    }

    @Override
    public UserDto delete(Long id) {
        UserDto user = findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Нет такого пользователя с ID '" + id + "'",404);
        }
        repository.deleteById(id);
        return user;
    }
}
