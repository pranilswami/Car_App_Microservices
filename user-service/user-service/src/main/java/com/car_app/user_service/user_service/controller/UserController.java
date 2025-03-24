package com.car_app.user_service.user_service.controller;

import com.car_app.user_service.user_service.entity.User;
import com.car_app.user_service.user_service.payload.JWTTokenDto;
import com.car_app.user_service.user_service.payload.LoginDto;
import com.car_app.user_service.user_service.payload.UserDto;
import com.car_app.user_service.user_service.repo.UserRepository;
import com.car_app.user_service.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("Username already exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opEmailId = userRepository.findByEmailId(user.getEmailId());
        if(opEmailId.isPresent()){
            return new ResponseEntity<>("Email Id already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("adding user..");
        return new ResponseEntity<>(userService.registerUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{userId}")
    public UserDto getUserById(@PathVariable Long userId){
        logger.info("getting user by id..");
        UserDto userDto = userService.getUserById(userId);
        System.out.println(userDto.getName()+"------"+userDto.getEmailId()+"---------"+userDto.getUsername());
        return userDto;
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        logger.info("getting user by email..");
        return userService.getUserByEmail(email);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> userLogin(@RequestBody LoginDto dto){
//        String jwtToken = userService.verifyLogin(dto);
//        if(jwtToken!=null){
//            JWTTokenDto tokenDto = new JWTTokenDto();
//            tokenDto.setToken(jwtToken);
//            tokenDto.setTokenType("JWT");
//            return new ResponseEntity<>(tokenDto,HttpStatus.CREATED);
//        }
//        logger.info("user logging..");
//        return new ResponseEntity<>("Invalid token ",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
