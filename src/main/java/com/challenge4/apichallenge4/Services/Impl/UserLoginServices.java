package com.challenge4.apichallenge4.Services.Impl;

import com.challenge4.apichallenge4.Dto.User.UserDtoRegis;
import com.challenge4.apichallenge4.Entity.User;


public interface UserLoginServices {
    public User findByNama(String nama);
    public User findByEmail(String email);
    public User findByPassword(String password);

    public User saveUser(UserDtoRegis userDtoRegis);

}
