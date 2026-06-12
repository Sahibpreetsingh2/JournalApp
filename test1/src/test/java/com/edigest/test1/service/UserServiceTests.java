//package com.edigest.test1.service;
//
//import com.edigest.test1.Entity.User;
//import com.edigest.test1.REPOSITORY.UserRepository;
//import com.edigest.test1.Service.UserService;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
////    @Disabled  for avoid test to run
//
//    @Autowired
//    private UserService userService;
//
////    @BeforeAll
////    void Setnew(){
////
////    }
////    @AfterAll
////    void setUP(){
////
////    }
//@ParameterizedTest
//@ArgumentsSource(UserArgumentsProvider.class) // ArgumentSource // EnumSource  // ValueSource
//    public void testfindByUserName(User user){
////        User user = userRepository.findByUserName("Jamson");
////        assertNotNull(userRepository.findByUserName(user));
////        assertTrue(!user.getJournalEntries().isEmpty());
//    assertTrue(userService.saveNewUser(user));
//
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a , int b , int expected){
//        assertEquals( expected , a+b);
//    }
//}
