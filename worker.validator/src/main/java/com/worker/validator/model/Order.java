package com.worker.validator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {
    private Long id;
    private String name;
    private String email;
    private Long product;
    private BigDecimal value;
    private String cpf;
    private Date createdAt;
    private String zipCode;
    private CreditCard creditCard;
}
