package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Entity.Produk;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Entity.Wishlist;
import com.challenge4.apichallenge4.Services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    @PostMapping("wishlist/add")
    public ResponseEntity<?> addWishList(@RequestBody Produk product) {
        User user = new User();
        Wishlist wishList = new Wishlist(user, product);
        wishlistService.createWishlist(wishList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
