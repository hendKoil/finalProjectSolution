package com.challenge4.apichallenge4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "img_produk")
public class ImageProduk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private int idImage;
    
    @Lob
    @Column(name = "image")
    private byte[] img;
}
