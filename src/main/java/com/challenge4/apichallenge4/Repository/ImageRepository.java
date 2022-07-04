package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.ImageProduk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ImageRepository extends JpaRepository<ImageProduk, Integer> {
}
