package com.challenge4.apichallenge4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Kategori")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kategori_id")
    private int kategoriId;
    @Column (name = "nama_kategori")
    private String namaKategori;
}
