package com.altonchan.orderservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_order_qty_data")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class OrderQtyData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID uuid;

    @Column
    private BigDecimal orderQty;

    @Column
    private BigDecimal cashOrderQty;

    @Column
    private BigDecimal orderPercent;

    @ManyToOne
    @JoinColumn(name = "cl_order_id")
    private Order order;
}
