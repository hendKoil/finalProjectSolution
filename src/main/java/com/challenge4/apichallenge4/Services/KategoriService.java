package com.challenge4.apichallenge4.Services;

import com.challenge4.apichallenge4.Dto.KategoriDto;
import com.challenge4.apichallenge4.Entity.Kategori;
import com.challenge4.apichallenge4.Repository.KategoriRepo;
import com.challenge4.apichallenge4.Repository.KategoriRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService {
    @Autowired
    KategoriRepo kategoriRepo;

    @Autowired
    KategoriRepo2 kategoriRepo2;

    public Kategori submitKategori(KategoriDto kategoriDto){
        Kategori save = new Kategori();
        save.setNamaKategori(kategoriDto.getNamaKategori());
        return kategoriRepo.save(save);
    }

    public List<Kategori> getAllKategori(){
        return kategoriRepo.findAll();
    }

    public List<Kategori> getByCode(int idKategori){
        return kategoriRepo.findBykategoriId(idKategori);
    }

    public Kategori updateKategori(KategoriDto kategoriDto, int idKategori){
        Kategori set = new Kategori();
        try{
            Kategori update = kategoriRepo2.findBykategoriId(idKategori);
            if (update != null){
                update.setNamaKategori(kategoriDto.getNamaKategori());
                set = kategoriRepo2.save(update);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return set;

    }

    public List<Kategori> deleteKategori(int idKategori){
        Kategori fDelete = kategoriRepo2.findBykategoriId(idKategori);
        if (fDelete != null){
            kategoriRepo2.deleteById(idKategori);
        }
        return kategoriRepo2.findAll();
    }
}
