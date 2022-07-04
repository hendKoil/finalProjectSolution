package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    public User findByNama(String nama);
    public User findByEmail(String email);
    public User findByPassword(String password);
    public List<User> findByUserId(int userId);
    public User findByUserId(Integer userId);
//    User save(UserDto userDto);
}
