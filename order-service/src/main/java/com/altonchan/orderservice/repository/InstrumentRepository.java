package com.altonchan.orderservice.repository;


import com.altonchan.orderservice.model.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, BigInteger> {
    List<Instrument> findByCfiCOdeIn(List<String> cfiCode);
    boolean existsByCfiCode(String cfiCode);
}
