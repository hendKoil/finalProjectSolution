package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.User.UserDto;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Services.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/display-all")
    @ApiOperation(value = "Endpoint update user.", notes = "Please fill form like a example",
            response = UserDto.class)
    public ResponseEntity<?> usersList(){
        return new ResponseEntity<>(userService.listUserSvc(), HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @PutMapping("user/update/{userId}")
    @ApiOperation(value = "Endpoint update user.", notes = "Please fill form like a example",
            response = UserDto.class)
    public ResponseEntity<?> userUpdate(
            @PathVariable("userId") int userId,
            @RequestParam(value = "img", required = false) MultipartFile file,
            String nama,
            String kota,
            String provinsi,
            String alamat,
            String noHandphone){
        List<User> lsUSer = userService.updateUser(userId, file, nama, kota, provinsi, alamat, noHandphone);
        return new ResponseEntity<>(userService.displayById(userId), HttpStatus.OK);
    }


    @GetMapping("user/display-by-id/{userId}")
    @ApiOperation(value = "Display by Id.", notes = "Please fill form like a example",
            response = UserDto.class)
//    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<?> selectByIdCtrl(@PathVariable("userId") int userId){
        return new ResponseEntity<>(userService.displayById(userId), HttpStatus.OK);
    }

    @DeleteMapping("user/user-delete-by-id/{userId}")
    @ApiOperation(value = "Delete by Id.", notes = "Please fill form like a example",
            response = UserDto.class)
    public ResponseEntity<?> deleteByIdCtrl(@PathVariable("userId") int userId){
        userService.deleteUserByIdSvc(userId);
        return new ResponseEntity<>(userService.listUserSvc(), HttpStatus.OK);
    }
}
