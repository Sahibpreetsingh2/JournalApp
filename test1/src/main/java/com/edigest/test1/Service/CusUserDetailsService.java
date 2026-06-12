package com.edigest.test1.Service;

import com.edigest.test1.Entity.User;
import com.edigest.test1.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CusUserDetailsService implements UserDetailsService {

   @Autowired
   private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepo.findByUserName(username);
      if(user!=null){
       UserDetails userDetails =   org.springframework.security.core.userdetails.User.builder()
                  .username(user.getUserName())
                  .password(user.getPassword())
                  .roles(user.getRoles().toArray(new String[0]))
                  .build();
          return userDetails;
      }

        throw new UsernameNotFoundException("User not found with username: " + username);

    }
}
