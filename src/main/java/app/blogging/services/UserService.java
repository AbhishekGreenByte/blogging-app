package app.blogging.services;


import app.blogging.payloads.UserDto;
import app.blogging.payloads.UserRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto createUser(UserRequestDto user);
    UserDto updateUser(UserRequestDto user,Long userId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
