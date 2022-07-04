package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;
import java.util.List;


@Entity
@DynamicUpdate
@Setter
@Getter
@Table (name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column (name = "nama", length = 100)
    private String nama;


    @Column (name = "provinsi")
    private String provinsi;


    @Column (name = "kota")
    private String kota;

    @Column(name = "email")
    private String email;

    @Column(name = "password", length = 100)
    private String password;


    @Column(name = "alamat")
    private String alamat;


    @Column(name = "no_handphone")
    private String noHandphone;//change to string because add zero in first number

    @Lob
    private byte[] img;



}



