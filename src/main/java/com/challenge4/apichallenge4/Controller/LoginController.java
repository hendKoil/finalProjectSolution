package com.challenge4.apichallenge4.Controller;


import com.challenge4.apichallenge4.Dto.User.UserDto;
import com.challenge4.apichallenge4.Dto.User.UserDtoLogin;
import com.challenge4.apichallenge4.Dto.User.UserDtoRegis;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Services.Impl.UserLoginServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController  {
    @Autowired
    UserLoginServiceImpl userLoginService;


    @PostMapping("/registration")
    @ApiOperation(value = "Endpoint register", notes = "Please fill form like a example",
            response = UserDtoRegis.class)
    public ResponseEntity<?> registration (@RequestBody UserDtoRegis userDtoRegis){
        Map <String, Object> map = new HashMap<>();
        User userLogin = userLoginService.findByEmail(userDtoRegis.getEmail());
        if (userLogin !=null){
            map.put(userDtoRegis.getEmail(), "email already exist");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }else {
            User getData = userLoginService.saveUser(userDtoRegis);
            map.put("userId", getData.getUserId());
            map.put("nama", getData.getNama());
            map.put("email", getData.getEmail());
            // ngge njagani lek FE jaluk response non encode password nembak ko dtoregis
            map.put("password", userDtoRegis.getPassword());
        }
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    @ApiOperation(value = "Endpoint Login", notes = "Please fill form like a example",
            response = UserDtoLogin.class)
    public ResponseEntity<?> login (@RequestBody UserDtoLogin user) {
        User userLogin = userLoginService.findByEmail(user.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
