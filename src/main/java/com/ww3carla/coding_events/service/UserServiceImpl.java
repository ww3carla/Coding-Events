package com.ww3carla.coding_events.service;

import com.ww3carla.coding_events.mapper.RoleMapper;
import com.ww3carla.coding_events.mapper.UserMapper;
import com.ww3carla.coding_events.models.RegistrationRequest;
import com.ww3carla.coding_events.models.User;
import com.ww3carla.coding_events.models.dto.UserDto;
import com.ww3carla.coding_events.repository.RoleRepository;
import com.ww3carla.coding_events.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public boolean checkEmail(String email){
        return userRepository.existsByEmailAddress(email);
    }

    @Override
    public UserDto registerUser(RegistrationRequest registrationRequest) {
        User user = User.builder()
                .username(registrationRequest.getUsername())
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .password(registrationRequest.getPassword())
                .emailAddress(registrationRequest.getEmailAddress())
                .role((roleRepository.findByRole("USER")))
                .build();
        return this.createUser(user);
    }

    public UserDto getLoginUser() {
        return userMapper.userEntityToDto(userRepository.findLoginUser().orElse(null));
    }

    public UserDto getUserById (Integer id){
        return userMapper.userEntityToDto(userRepository.findById(id).orElse(null));
    }

    public List<UserDto> getAllUsers(){
        return userMapper.userListEntityToDto(userRepository.findAll());
    }

    public UserDto createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMapper.userEntityToDto(userRepository.save(user));
    }

    public UserDto updateUser(User user) {
        return userMapper.userEntityToDto(userRepository.save(user));
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
