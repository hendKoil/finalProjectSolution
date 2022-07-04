package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Penawaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PenawaranRepository extends JpaRepository<Penawaran, Integer> {

}
