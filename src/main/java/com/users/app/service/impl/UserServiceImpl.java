package com.users.app.service.impl;

import com.users.app.entity.User;
import com.users.app.exceptions.ResourceNotFound;
import com.users.app.payload.UserDTO;
import com.users.app.repository.UserRepository;
import com.users.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        User user = mapToEntity(userDTO);
        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);

    }

    @Override
    public List<UserDTO> listUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new
                ResourceNotFound("User", "id",id));

        return mapToDTO(user);

    }

    @Override
    public UserDTO upgradeUser(UserDTO userDTO, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new
                ResourceNotFound("User", "id",id));

        user.setIdentification(userDTO.getIdentification());
        user.setName(userDTO.getName());
        user.setEmail(user.getEmail());

        User updateUser = userRepository.save(user);

        return mapToDTO(updateUser);

    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new
                ResourceNotFound("User", "id",id));
        userRepository.delete(user);



    }

    private UserDTO mapToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    private User mapToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
