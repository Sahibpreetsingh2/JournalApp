//package com.edigest.test1.service;
//
//import com.edigest.test1.Entity.User;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
////import org.springframework.security.core.userdetails.User;
//
//import java.util.stream.Stream;
//
////import static jdk.internal.util.StaticProperty.userName;
//
//public class UserArgumentsProvider implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments>
//    provideArguments(ExtensionContext context)
//            throws Exception {
//        return Stream.of(
//                Arguments.of(User.builder()
//                        .userName("itsme")
//                        .password("itsme")
//                        .build())
//                );
//    }
//}
