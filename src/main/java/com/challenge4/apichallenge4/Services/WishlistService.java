package com.challenge4.apichallenge4.Services;

import com.challenge4.apichallenge4.Entity.Wishlist;
import com.challenge4.apichallenge4.Repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WishlistService {
    @Autowired
    WishlistRepo wishlistRepo;

    public WishlistService(WishlistRepo wishListRepo) {
        this.wishlistRepo = wishListRepo;
    }

    public void createWishlist(Wishlist wishList) {
        wishlistRepo.save(wishList);
    }

    public List<Wishlist> readWishList(int userId) {
        return wishlistRepo.findAllByUserUserId(userId);
    }
}
