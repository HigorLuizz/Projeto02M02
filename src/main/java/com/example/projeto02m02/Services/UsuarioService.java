package com.example.projeto02m02.Services;

import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }
    public void save(UsuarioEntity usuario){
        repository.save(usuario);
    }

}
