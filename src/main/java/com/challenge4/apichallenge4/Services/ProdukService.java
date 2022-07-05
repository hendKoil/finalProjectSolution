package com.challenge4.apichallenge4.Services;

import com.challenge4.apichallenge4.Entity.Produk;
import com.challenge4.apichallenge4.Repository.ProdukRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdukService {
    @Autowired
    ProdukRepo produkRepo;

public Produk getByIdProduk(int idProduk){
    return produkRepo.findByIdProduk(idProduk);
}

}
