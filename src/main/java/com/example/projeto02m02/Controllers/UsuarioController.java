package com.example.projeto02m02.Controllers;

import com.example.projeto02m02.Dtos.UsuarioDto;
import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Services.UsuarioService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService service;
    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping("/cadastro")
    public ResponseEntity save(@RequestBody UsuarioEntity usuario){

        service.save(usuario);
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setDados(usuario);

        return new ResponseEntity<>(new UsuarioDto(Response.SC_CREATED, "Usuario cadastrado com sucesso", usuarioDto.getDados()), HttpStatus.CREATED);
    }

    @PutMapping("/cadastro")
    public ResponseEntity update(@RequestBody UsuarioEntity usuario){

        service.save(usuario);
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setDados(usuario);

        return new ResponseEntity<>(new UsuarioDto(Response.SC_OK, "Usuario atualizado com sucesso", usuarioDto.getDados()), HttpStatus.OK);

    }

    @GetMapping("/login")
    public ResponseEntity buscarTodosUsuarios(){
        return service.buscarUsuarios();
    }

    @GetMapping("/login/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
}
