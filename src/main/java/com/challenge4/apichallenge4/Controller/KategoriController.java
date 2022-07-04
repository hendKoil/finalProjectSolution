package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.KategoriDto;
import com.challenge4.apichallenge4.Entity.Kategori;
import com.challenge4.apichallenge4.Services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class KategoriController {
    @Autowired
    KategoriService kategoriService;

    @PostMapping("api/kategori/submit")
    public ResponseEntity<?> submitKategori(@RequestBody KategoriDto kategoriDto){
        Kategori save = kategoriService.submitKategori(kategoriDto);
        if (save != null){
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(save, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("api/kategori/select-all")
    public ResponseEntity<?> selectAllKategori(){
        List<Kategori> select = kategoriService.getAllKategori();
        if (select != null){
            return new ResponseEntity<>(select, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(select, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("api/kategori/select-by-id/{id}")
    public ResponseEntity<?> selectById(@PathVariable("id") int idKategori){
        List<Kategori> selectId = kategoriService.getByCode(idKategori);
        if (selectId != null){
            return new ResponseEntity<>(selectId, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(selectId, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("api/kategori/update/{id}")
    public ResponseEntity<?> kategoriUpdate(@PathVariable ("id") int idKategori, @RequestBody KategoriDto kategoriDto){
        try{
            Kategori update = kategoriService.updateKategori(kategoriDto, idKategori);
            return new ResponseEntity<>(update, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("api/kategori/delete/{id}")
    public ResponseEntity<?> kategoriDelete(@PathVariable ("id") int idKategori){
        List<Kategori> delete = kategoriService.deleteKategori(idKategori);
        return new ResponseEntity<>(delete, HttpStatus.ACCEPTED);
    }
}
