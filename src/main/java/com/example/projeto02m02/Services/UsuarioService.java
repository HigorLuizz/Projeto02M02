package com.example.projeto02m02.Services;

import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }
    public void save(UsuarioEntity usuario){
        repository.save(usuario);
    }

    public List<UsuarioEntity> buscarUsuarios(){
        if(repository.findAll().isEmpty()){
            throw new NullPointerException();
        }else{
            return repository.findAll();
        }
    }

    public UsuarioEntity findById(Long id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }else{
            throw new NullPointerException();
        }

    }

}
