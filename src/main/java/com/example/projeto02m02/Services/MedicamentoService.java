package com.example.projeto02m02.Services;

import com.example.projeto02m02.Dtos.MedicamentoDto;
import com.example.projeto02m02.Dtos.MedicamentosDto;
import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Repositories.MedicamentoRepository;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity buscarMedicamentos(){
        if(repository.findAll().isEmpty()){
            throw new NullPointerException();
        }else{
            List<MedicamentoEntity> medicamentos = repository.findAll();

            MedicamentosDto medicamentosDto = new MedicamentosDto();

            return new ResponseEntity(new MedicamentosDto(Response.SC_FOUND,"Medicamentos escontrados!",medicamentos),HttpStatus.FOUND);
        }
    }
    public MedicamentoEntity findById(Long id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }else{
            throw new NullPointerException();
        }

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
