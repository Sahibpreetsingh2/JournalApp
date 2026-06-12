//package com.edigest.test1.service;
//
//import com.edigest.test1.Entity.User;
//import com.edigest.test1.REPOSITORY.UserRepository;
//import com.edigest.test1.Service.CusUserDetailsService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import java.util.ArrayList;
//
//import  static org.mockito.Mockito.*;
//
//
//public class UserDetailsServiceImplTests {
//
//    @InjectMocks
//    private CusUserDetailsService userDetailsService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.initMocks(this);
//
//    }
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(
//                User.builder()
//                .userName("john")
//                .password("353jk")
//                .roles(new ArrayList<>())
//                .build());
//        UserDetails user = userDetailsService.loadUserByUsername("robert");
//    }
//}
