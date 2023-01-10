package kg.charginov.userservice.service;

import kg.charginov.userservice.model.dto.UserDto;
import kg.charginov.userservice.model.dto.UserRequest;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findUserById(Long id);

    UserDto save(UserRequest request);

    UserDto delete(Long id);

}
