package com.example.InstaCopy.service;


import com.example.InstaCopy.entity.User;
import com.example.InstaCopy.entity.enums.ERole;
import com.example.InstaCopy.exceptions.UserExistException;
import com.example.InstaCopy.payload.response.request.SignupRequest;
import com.example.InstaCopy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getFirstname());
        user.setLastname(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRole().add(ERole.ROLE_USER);

        try{
            LOG.info("Saving user {}", userIn.getEmail());
            return userRepository.save(user);
        }catch(Exception e){
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user"  + user.getUsername() + "already exist. Please check credentials");
        }

    }
}
