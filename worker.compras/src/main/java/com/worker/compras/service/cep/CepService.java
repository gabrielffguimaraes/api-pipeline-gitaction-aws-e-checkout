package com.worker.compras.service.cep;

import com.worker.compras.model.entity.Address;
import com.worker.compras.repository.CepRepository;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    private final CepRepository cepRepository;

    public CepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    public Address pegarEndereco(String cep) {
        return cepRepository.buscarPorCep(cep);
    }
}
