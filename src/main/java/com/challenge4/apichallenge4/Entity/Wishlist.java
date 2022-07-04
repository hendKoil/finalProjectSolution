package com.challenge4.apichallenge4.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int WishlistId;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "id_produk")
    private Produk produk;

    public Wishlist(User user, Produk produk) {
        this.user = user;
        this.produk = produk;
        this.createdDate = new Date();
    }

}
