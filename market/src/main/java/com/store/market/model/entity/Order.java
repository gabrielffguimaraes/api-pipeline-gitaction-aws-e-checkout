package com.store.market.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String name;
    private String email;
    private Long product;
    private BigDecimal value;
    private String cpf;
    private Date createdAt;
    private String zipCode;
}

