package com.example.projeto02m02.Services;

import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {
    private MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repositoty){
        this.repository = repositoty;
    }

    public void save(MedicamentoEntity medicamento){
        repository.save(medicamento);
    }
    public List<MedicamentoEntity> buscarMedicamentos(){

        return repository.findAll();
    }
    public MedicamentoEntity findById(Long id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }else{
            return null;
        }

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
