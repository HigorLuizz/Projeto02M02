package com.example.projeto02m02.Services;

import com.example.projeto02m02.Entities.EnderecoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Repositories.EnderecoRepository;
import com.example.projeto02m02.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private EnderecoRepository repository;
    public EnderecoService(EnderecoRepository repository){
        this.repository = repository;
    }
    public void save(EnderecoEntity endereco){
        repository.save(endereco);
    }
}
