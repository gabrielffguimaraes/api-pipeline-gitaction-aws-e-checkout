package com.worker.compras.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    @JsonProperty("cep")
    public String zipCode;
    @JsonProperty("logradouro")
    public String street;
    @JsonProperty("complemento")
    public String complement;
    @JsonProperty("bairro")
    public String district;
    @JsonProperty("localidade")
    public String state;
    @JsonProperty("uf")
    public String federatedState;
    @JsonProperty("ibge")
    public String ibge;
    @JsonProperty("gia")
    public String gia;
    @JsonProperty("ddd")
    public String ddd;
    @JsonProperty("siafi")
    public String siafi;
}
