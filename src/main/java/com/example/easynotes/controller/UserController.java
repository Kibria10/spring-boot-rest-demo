package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUser() {return userRepository.findAll();}

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails){
       User currentUser =  userRepository.findById(userId)
               .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));

       currentUser.setName(userDetails.getName());
       currentUser.setEmail(userDetails.getEmail());
       currentUser.setAddress(userDetails.getAddress());
//       currentUser.setDob(userDetails.getDob());
       currentUser.setMobile_no(userDetails.getMobile_no());
       currentUser.setGender(userDetails.getGender());

       User updateUser = userRepository.save(currentUser);
       return updateUser;

    }
}
