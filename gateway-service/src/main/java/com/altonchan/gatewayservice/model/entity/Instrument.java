package com.altonchan.gatewayservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "tb_instrument")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT", name = "instrument_id")
    private BigInteger id;

    @ManyToMany
    @JoinTable(
            name = "tb_order_instrument_mapping",
            joinColumns = @JoinColumn(name = "instrument_id"),
            inverseJoinColumns = @JoinColumn(name = "cl_order_id")
    )
    private List<Order> orderList;

    @Column(name = "cfi_code")
    private String cfiCode;
}
