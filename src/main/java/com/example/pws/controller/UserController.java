package com.example.pws.controller;

import com.example.pws.dto.CreateUserRequest;
import com.example.pws.dto.UpdateEmailRequest;
import com.example.pws.model.User;
import com.example.pws.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users" )
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping("/create" )
    public User createUser(@Valid @RequestBody CreateUserRequest request )
    {
        User user = userService.createUser(request) ;
        return user;
    }

    @GetMapping("/{id}" )
    public User getUser(@PathVariable String id )
    {
        User user= userService.getUserById(id) ;
        return user ;
    }

    @PutMapping("/update/{id}" )
    public User updateEmail(@PathVariable String id, @Valid @RequestBody UpdateEmailRequest request ) throws MethodArgumentNotValidException
    {
        User user= userService.updateEmailById(id, request ) ;
        return user ;
    }

    @DeleteMapping("/delete/{id}" )
    public ResponseEntity<String > deleteUser(@PathVariable String id )
    {
//        String message= userService.deleteUserById(id ) ;
//        ResponseEntity<String > ms= new ResponseEntity<String >(message,HttpStatus.OK) ;
//        System.out.println("=============================================");
//        System.out.println(message);
//        return ms;
        String message = userService.deleteUserById(id);

        // Check if the service returned null or a specific message
        if (message == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Use OK (200) to ensure the body message is sent to the client
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
