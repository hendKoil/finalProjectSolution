package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface KategoriRepo2 extends JpaRepository<Kategori, Integer> {
    public Kategori findBykategoriId(int id);
}
