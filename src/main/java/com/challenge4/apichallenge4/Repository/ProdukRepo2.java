package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProdukRepo2 extends JpaRepository<Produk, Integer> {
    List<Produk> findByIdProduk(int idProduk);
    public Produk findByIdProduk(Integer idProduk);
}
