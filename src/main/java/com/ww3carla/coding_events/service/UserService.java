package com.ww3carla.coding_events.service;

import com.ww3carla.coding_events.models.RegistrationRequest;
import com.ww3carla.coding_events.models.User;
import com.ww3carla.coding_events.models.dto.UserDto;
import jakarta.servlet.Registration;

import java.util.List;

public interface UserService {
    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    UserDto createUser(User user);

    UserDto updateUser(User user);

    void deleteUser(User user);

}
