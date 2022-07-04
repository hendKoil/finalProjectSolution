package com.challenge4.apichallenge4.Services;

import com.challenge4.apichallenge4.Dto.PenawaranDto;
import com.challenge4.apichallenge4.Entity.Penawaran;
import com.challenge4.apichallenge4.Entity.Produk;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Repository.PenawaranRepository;
import com.challenge4.apichallenge4.Repository.ProdukRepo2;
import com.challenge4.apichallenge4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PenawaranService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProdukRepo2 produkRepo2;

    @Autowired
    PenawaranRepository penawaranRepository;

    public Penawaran submitPenawaran(PenawaranDto penawaranDto){
//        List<User> user = userRepository.findByUserId(penawaranDto.getUser().getUserId());
        User user = userRepository.findByUserId(new Integer(penawaranDto.getUser().getUserId()));
//        List<Produk> produk = produkRepo2.findByIdProduk(penawaranDto.getProduk().getIdProduk());
        Produk produk = produkRepo2.findByIdProduk(new Integer(penawaranDto.getProduk().getIdProduk()));
        Penawaran save = new Penawaran();
        save.setPenawaranId(penawaranDto.getPenawaranId());
        save.setHargaTawar(penawaranDto.getHargaTawar());
        save.setUserId(user.getUserId());
        save.setProdukId(produk.getIdProduk());
        save.setCreatedAt(new Date());
        save.setStatus(penawaranDto.getStatus());
        return penawaranRepository.save(save);
    }
}