package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {
    public List<Wishlist> findAllByUserUserId(int userId);
}
