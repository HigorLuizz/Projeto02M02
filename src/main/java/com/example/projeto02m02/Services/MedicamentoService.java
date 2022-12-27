package com.example.projeto02m02.Services;

import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
    private MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repositoty){
        this.repository = repositoty;
    }

    public void save(MedicamentoEntity medicamento){
        repository.save(medicamento);
    }
}
