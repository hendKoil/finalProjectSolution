package com.challenge4.apichallenge4.Dto.User;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;


@Setter
@Getter
public class UserDto {
    private int userId;
    private String nama;
    private String email;
    private String password;
    private String provinsi;
    private String kota;
    private String alamat;
    private String noHandphone; //change to string because add zero in first number
    private MultipartFile img;

    // you can set role buyer/seller in the regis
//    private int roleId;
}
