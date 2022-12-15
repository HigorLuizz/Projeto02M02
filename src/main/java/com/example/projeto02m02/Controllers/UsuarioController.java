package com.example.projeto02m02.Controllers;

import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService service;
    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping("/cadastro")
    public void save(@RequestBody UsuarioEntity usuario){
        service.save(usuario);
    }

    @PutMapping("/cadastro")
    public void update(@RequestBody UsuarioEntity usuario){
        service.save(usuario);
    }
}
