package com.example.projeto02m02.Services;

import com.example.projeto02m02.EnderecoViaCep;
import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Feign.FeignClient;
import com.example.projeto02m02.Repositories.FarmaciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FarmaciaService {
    private final FeignClient feign;
    private FarmaciaRepository repository;

    public FarmaciaService(FarmaciaRepository repository, FeignClient feign) {
        this.repository = repository;
        this.feign = feign;
    }

    public void saveFarmacia(FarmaciaEntity farmacia){
        EnderecoViaCep evc= feign.buscaCep(farmacia.getIdEndereço().getCep());
    }
}
