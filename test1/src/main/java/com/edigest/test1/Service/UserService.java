package com.edigest.test1.Service;

import com.edigest.test1.Entity.User;
import com.edigest.test1.REPOSITORY.UserRepository;
//import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    public  PasswordEncoder passEncoder =new BCryptPasswordEncoder();

    private  static final Logger logger = LoggerFactory.getLogger(UserService.class);
    public void saveUser(User user){
        userRepo.save(user);
    }

    public boolean saveNewUser(User user){
        try {
            user.setPassword(passEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);

           // log.info("User created successfully : {}", user.getUserName());
            return true;
        }
        catch(Exception e){
//            logger.info("hahahah;aha");

            logger.error("Error occured {} :" ,user.getUserName(),e);
        //  log.error("Error occured {} :" ,user.getUserName(),e);
            return false;
        }
    }
    public void  saveAdmin(User user){
        user.setPassword(passEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER" ," ADMIN"));
        userRepo.save(user);
    }

    public List<User> getAll(){ return userRepo.findAll(); }

    public Optional<User> findById(ObjectId id) { return userRepo.findById(id); }

    public void deleteById(ObjectId id) { userRepo.deleteById(id);}


    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
    // controller --> sevice ---> reppsitory
}
