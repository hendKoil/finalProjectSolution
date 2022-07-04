package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Produk;
import com.challenge4.apichallenge4.Entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PenawaranDto {
    private int penawaranId;
    private int hargaTawar;
    private User user;
    private Produk produk;
    private Boolean status;
}
