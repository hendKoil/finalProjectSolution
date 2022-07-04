package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {
    public List<User> findAll();
    public User findByUserId(int userId);
//    public List<User> findByUserIdUserId(int userId);
//public User findByUsername(String username);
}
