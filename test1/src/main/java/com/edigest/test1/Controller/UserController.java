package com.edigest.test1.Controller;



import com.edigest.test1.Entity.User;
import com.edigest.test1.REPOSITORY.UserRepository;
import com.edigest.test1.Service.UserService;
import com.edigest.test1.Service.weatherservice;
import com.edigest.test1.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private weatherservice weatherServ;

//    @GetMapping
//    public List<User> getAlluser(){
//        return userService.getAll();
//
//    }

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        userService.savedEntry(user);
//        return new ResponseEntity<>(user,HttpStatus.OK);
//    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
       User userInDB =  userService.findByUserName(userName);
       if(userInDB != null){
           userInDB.setUserName(user.getUserName());
           userInDB.setPassword(user.getPassword());
           userService.saveNewUser(userInDB);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherServ.getWeather("Mumbai");
        String greeting ="";
        if(weatherResponse != null){
            greeting =",Weather feels like"+weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi" + authentication.getName() + greeting ,HttpStatus.OK);
    }


}
