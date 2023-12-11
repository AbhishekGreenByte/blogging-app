package app.blogging.services.impl;

import app.blogging.entities.User;
import app.blogging.exceptions.DTOValidationException;
import app.blogging.exceptions.ResourceNotFoundException;
import app.blogging.payloads.UserDto;
import app.blogging.payloads.UserRequestDto;
import app.blogging.repositories.UserRepo;
import app.blogging.services.UserService;
import app.blogging.validation.ValidateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    //Database Access
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserRequestDto userDto) {
        boolean status=ValidateDTO.validUserRequestDto(userDto);
        if(!status){
            throw new DTOValidationException("UserRequestDTO","Invalid Format");
        }
        User obj=userRepo.findUserByEmail(userDto.getEmail());
        if(obj!=null){
            throw new DTOValidationException("Email","Email Already Exists");
        }
        User user=this.modelMapper.map(userDto,User.class);
        User savedUser=this.userRepo.save(user);
        return this.modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto updateUser(UserRequestDto userDto, Long userId) {
        User user=userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
        boolean status=ValidateDTO.validUserRequestDto(userDto);
        if(!status){
            throw new DTOValidationException("UserRequestDTO","Invalid Format");
        }
        //Update->> Vulnerable
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser=this.userRepo.save(user);
        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user=userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepo.findAll();
        return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
        userRepo.delete(user);
    }
}
