package com.car_app.user_service.user_service.service;

import com.car_app.user_service.user_service.entity.User;
import com.car_app.user_service.user_service.payload.LoginDto;
import com.car_app.user_service.user_service.payload.UserDto;
import com.car_app.user_service.user_service.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        String hashpw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmailId(email).orElseThrow(()->new RuntimeException("USER NOT FOUND WITH GIVEN EMAIL-ID"));
    }

//    public String verifyLogin(LoginDto dto){
//        Optional<User> opUser = userRepository.findByUsername(dto.getUsername());
//        if(opUser.isPresent()){
//            User user = opUser.get();
//            if(BCrypt.checkpw(dto.getPassword(), user.getPassword())){
//                return jwtService.generateToken(user.getUsername());
//            }
//        }
//        return null;
//    }

    public UserDto getUserById(Long id) {
        System.out.println("Given ID :============================ "+id);
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("USER NOT FOUND BY GIVEN ID"));
        System.out.println(user.getName()+"------"+user.getEmailId()+"---------"+user.getUsername());
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }
}
