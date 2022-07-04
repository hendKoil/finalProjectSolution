package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProdukRepo extends JpaRepository<Produk, Integer> {
    Produk findByIdProduk(int idProduk);
    List<Produk> findByNamaProduk(String namaProduk);
    List<Produk> findAll();
}
