package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Produk")
@Getter
@Setter
//@AllArgsConstructor
public class Produk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produk")
    private int idProduk;

    @Column(name = "nama_produk")
    private String namaProduk;

    @Lob
    @Column(name = "deskripsi_produk")
    private String deskripsiProduk;

    @Column(name = "harga_produk")
    private int hargaProduk;

    @Column(name = "status_produk")
    private Boolean statusProduk;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;


}
