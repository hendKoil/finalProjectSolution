package com.challenge4.apichallenge4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@Table(name = "penawaran")
@AllArgsConstructor
@NoArgsConstructor

public class Penawaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penawaran_id")
    private int penawaranId;

    @Column (name = "harga_tawar")
    private int hargaTawar;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_id")
    private int produkId;

    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // initialize created date

//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt = new Date(); // initialize updated date

    @Column (name = "status_penawaran")
    private Boolean status;
}
