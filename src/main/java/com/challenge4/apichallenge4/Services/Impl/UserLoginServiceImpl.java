package com.challenge4.apichallenge4.Services.Impl;


import com.challenge4.apichallenge4.Dto.User.UserDto;
import com.challenge4.apichallenge4.Dto.User.UserDtoRegis;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Repository.UserRepo;
import com.challenge4.apichallenge4.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginServiceImpl implements UserLoginServices, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRepo userRepo;
    public final PasswordEncoder passwordEncoder;
    private final Logger logger = LogManager.getLogger(UserLoginServiceImpl.class);

    @Override
    public User findByNama(String nama) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByPassword(String password) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            logger.error("user not found");
        } else {
            logger.info(email + "user found ");
        }
        Collection <SimpleGrantedAuthority > simpleGrantedAuthorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), simpleGrantedAuthorities);
    }

    public User saveUser(UserDtoRegis userDtoRegis) {
        User saveUser = new User();
//        saveUser.setUserId(userDtoRegis.getUserId());
        saveUser.setNama(userDtoRegis.getNama());
        saveUser.setEmail(userDtoRegis.getEmail());
        saveUser.setPassword(passwordEncoder.encode(userDtoRegis.getPassword()));
        return userRepository.save(saveUser);
    }


}
