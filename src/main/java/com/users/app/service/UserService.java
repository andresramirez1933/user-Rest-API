package com.users.app.service;

import com.users.app.payload.UserDTO;

import java.util.List;

public interface UserService{

    UserDTO registerUser(UserDTO userDTO);

    List<UserDTO> listUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(UserDTO userDTO, Long id);

    void deleteUser(Long id);





}
