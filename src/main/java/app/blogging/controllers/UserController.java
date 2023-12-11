package app.blogging.controllers;

import app.blogging.payloads.ApiResponse;
import app.blogging.payloads.UserDto;
import app.blogging.payloads.UserRequestDto;
import app.blogging.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //Service
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequestDto user){
        UserDto createdUserDto=userService.createUser(user);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRequestDto user, @PathVariable Long userId){
        return new ResponseEntity<>(userService.updateUser(user,userId),HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }
}
