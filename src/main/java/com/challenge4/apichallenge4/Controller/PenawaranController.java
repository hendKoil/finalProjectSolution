package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.PenawaranDto;
import com.challenge4.apichallenge4.Entity.Penawaran;
import com.challenge4.apichallenge4.Entity.User;
import com.challenge4.apichallenge4.Services.PenawaranService;
import com.challenge4.apichallenge4.Services.ProdukService;
import com.challenge4.apichallenge4.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PenawaranController {
    @Autowired
    PenawaranService penawaranService;

    @Autowired
    UserService userService;

    @Autowired
    ProdukService produkService;


    @PostMapping("api/penawaran/submit")
    public ResponseEntity<?> saveKategori(@RequestBody PenawaranDto penawaranDto){
        User getUser = userService.displayById(penawaranDto.getUser().getUserId());
        if(getUser.getNama().equalsIgnoreCase("buyer")){
            Penawaran penawaran = penawaranService.submitPenawaran(penawaranDto);
            Map<String, Object> map = new HashMap<>();
            map.put("user",getUser);
            map.put("hargaTawar", penawaranDto.getHargaTawar());
            map.put("produk", produkService.getByIdProduk(penawaranDto.getProduk().getIdProduk()));
            map.put("status", penawaranDto.getStatus());
            map.put("created_at", new Date());
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        }
            return new ResponseEntity<> ("seller tidak boleh hit ini",HttpStatus.FORBIDDEN);
    }
}
