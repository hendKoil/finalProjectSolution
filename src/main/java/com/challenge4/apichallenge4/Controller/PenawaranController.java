package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.PenawaranDto;
import com.challenge4.apichallenge4.Entity.Penawaran;
import com.challenge4.apichallenge4.Services.PenawaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PenawaranController {
    @Autowired
    PenawaranService penawaranService;

    @PostMapping("api/penawaran/submit")
    public ResponseEntity<?> saveKategori(@RequestBody PenawaranDto penawaranDto){
        if(penawaranDto.getUser().getNama().equalsIgnoreCase("buyer")){
            Penawaran penawaran = penawaranService.submitPenawaran(penawaranDto);
            return new ResponseEntity<>(penawaran, HttpStatus.CREATED);
        }
            return new ResponseEntity<> ("seller tidak boleh hit ini",HttpStatus.FORBIDDEN);
    }
}
