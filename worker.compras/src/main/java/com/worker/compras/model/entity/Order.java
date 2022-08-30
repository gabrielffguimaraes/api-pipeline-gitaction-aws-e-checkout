package com.worker.compras.model.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@Entity
//@Table(name = "markert_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String name;
    @Column
    private String email;
    @Column(name="produto")
    private Long product;
    @Column(name="valor")
    private BigDecimal value;
    @Column(name="cpfCliente")
    private String cpf;
    @Column(name="dataCompra")
    private Date createdAt;
    @Column(name="cep")
    private String zipCode;
    @Column(name="cartaoDeCredito")
    private CreditCard creditCard;
}
