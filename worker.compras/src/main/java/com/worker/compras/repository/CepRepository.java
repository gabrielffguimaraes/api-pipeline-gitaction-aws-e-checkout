package com.worker.compras.repository;

import com.worker.compras.model.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep" , url= "${viacep}")
public interface CepRepository {
    @GetMapping("/{cep}/json")
    Address buscarPorCep(@PathVariable("cep") String cep);
}
