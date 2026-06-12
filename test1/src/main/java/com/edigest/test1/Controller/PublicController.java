package com.edigest.test1.Controller;


import com.edigest.test1.Entity.User;
import com.edigest.test1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;
//
//    @GetMapping("/health-check")z
//    public List<User> getAlluser(){
//        return userService.getAll();
//
//    }


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.saveNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }
}
