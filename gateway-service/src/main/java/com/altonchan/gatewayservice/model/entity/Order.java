package com.altonchan.gatewayservice.model.entity;

import com.altonchan.gatewayservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID clOrderID;

    @Column
    private char orderType;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;



}
