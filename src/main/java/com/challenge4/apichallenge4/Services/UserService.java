package com.challenge4.apichallenge4.Services;

import com.challenge4.apichallenge4.Dto.User.UserDto;
import com.challenge4.apichallenge4.Dto.User.UserDtoRegis;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Repository.UserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public List<User> listUserSvc(){
        return userRepo.findAll();
    }

    public User displayById(int userId) {
        return userRepo.findByUserId(userId);
    }

        public List<User> updateUser(int userId, MultipartFile file,
                                     String nama, String kota,
                                     String provinsi, String alamat,
                                     String noHandphone) {
        try {
            User user = userRepo.findByUserId(userId);
            if (user != null ) {
                if (file == null || file.isEmpty()) {
                    user.setImg(null);
                    user.setNama(nama);
                    user.setKota(kota);
                    user.setProvinsi(provinsi);
                    user.setAlamat(alamat);
                    user.setNoHandphone(noHandphone);
                    userRepo.save(user);
                    if (nama == null || nama.isEmpty()) {
                        user.setImg(user.getImg());
                        user.setNama(null);
                        user.setKota(kota);
                        user.setProvinsi(provinsi);
                        user.setAlamat(alamat);
                        user.setNoHandphone(noHandphone);
                        userRepo.save(user);
                    }
                    if (kota == null || kota.isEmpty()) {
                        user.setImg(user.getImg());
                        user.setNama(nama);
                        user.setKota(null);
                        user.setProvinsi(provinsi);
                        user.setAlamat(alamat);
                        user.setNoHandphone(noHandphone);
                        userRepo.save(user);
                    }
                    if (provinsi == null || provinsi.isEmpty()) {
                        user.setImg(user.getImg());
                        user.setNama(nama);
                        user.setKota(kota);
                        user.setProvinsi(null);
                        user.setAlamat(alamat);
                        user.setNoHandphone(noHandphone);
                        userRepo.save(user);
                    }
                    if (alamat == null || alamat.isEmpty()) {
                        user.setImg(user.getImg());
                        user.setNama(nama);
                        user.setKota(kota);
                        user.setProvinsi(provinsi);
                        user.setAlamat(null);
                        user.setNoHandphone(noHandphone);
                        userRepo.save(user);
                    }
                    if (noHandphone == null || noHandphone.isEmpty()) {
                        user.setImg(user.getImg());
                        user.setNama(nama);
                        user.setKota(kota);
                        user.setProvinsi(provinsi);
                        user.setAlamat(alamat);
                        user.setNoHandphone(null);
                        userRepo.save(user);
                    }

                } else {
                    user.setImg(file.getBytes());
                    user.setNama(nama);
                    user.setKota(kota);
                    user.setProvinsi(provinsi);
                    user.setAlamat(alamat);
                    user.setNoHandphone(noHandphone);
                    userRepo.save(user);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("user not found");
        }
        return null;
    }

    public  List <User> deleteUserByIdSvc(int userId){
        User delete = userRepo.findByUserId(userId);
        if (delete !=null){
            userRepo.deleteById(userId);
        }
        return userRepo.findAll();
    }

    public UserDtoRegis findProject(int userId) {
        // Get Project entity
        User project = userRepo.findByUserId(userId);
        // Map entity to dto
        UserDtoRegis dto = new UserDtoRegis();
        dto.setEmail(project.getPassword());
        dto.setPassword(project.getPassword());

        return dto;
    }
}
