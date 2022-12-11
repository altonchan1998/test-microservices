package com.altonchan.orderservice.model.entity;

import com.altonchan.orderservice.model.enums.OrdType;
import com.altonchan.orderservice.model.enums.Side;
import com.altonchan.orderservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cl_order_id")
    private UUID clOrderID;

    @ManyToMany(mappedBy = "orderList")
    private List<Instrument> instrumentList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column
    private Side side;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column
    private OrdType ordType;

    @Column
    private LocalDateTime transactTime;

    @OneToMany(mappedBy = "order")
    private List<OrderQtyData> orderQtyDataList = new ArrayList<>();
}
