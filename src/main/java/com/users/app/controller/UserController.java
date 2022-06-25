package com.users.app.controller;

import com.users.app.payload.UserDTO;
import com.users.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<UserDTO>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers(){

        return new ResponseEntity<List<UserDTO>>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){

        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){

        return new ResponseEntity<UserDTO>(userService.updateUser(userDTO, id ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){

        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted", HttpStatus.OK);
    }

}
