package com.example.projeto02m02.Controllers;


import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Entities.UsuarioEntity;
import com.example.projeto02m02.Services.MedicamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private MedicamentoService service;

    public MedicamentoController(MedicamentoService service){
        this.service = service;
    }

    @PostMapping("/cadastro")
    public void save(@RequestBody MedicamentoEntity medicamento){
        service.save(medicamento);
    }

    @PutMapping("/cadastro")
    public void update(@RequestBody MedicamentoEntity medicamento){
        service.save(medicamento);
    }
    @GetMapping
    public List<MedicamentoEntity> buscarTodosMedicamentos(){
        return service.buscarMedicamentos();
    }
    @GetMapping("/{id}")
    public MedicamentoEntity findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/cadastro/{id}")
    public void deleById(@PathVariable("id") Long id){
        service.deleteById(id);
    }
}
