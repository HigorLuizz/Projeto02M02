package com.example.projeto02m02.Controllers;


import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Services.MedicamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
    private MedicamentoService service;

    public MedicamentoController(MedicamentoService service){
        this.service = service;
    }

    @PostMapping("/cadastro")
    public void save(@RequestBody MedicamentoEntity medicamento){
        service.save(medicamento);
    }
}
