package com.example.projeto02m02.Controllers;
import com.example.projeto02m02.Dtos.DeleteDto;
import com.example.projeto02m02.Dtos.MedicamentoDto;
import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Services.MedicamentoService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity save(@RequestBody MedicamentoEntity medicamento){

        service.save(medicamento);
        MedicamentoDto medicamentoDto = new MedicamentoDto();
        medicamentoDto.setDados(medicamento);

        return new ResponseEntity<>(new MedicamentoDto(Response.SC_CREATED, "Medicamento criado com sucesso", medicamentoDto.getDados()), HttpStatus.CREATED);

    }

    @PutMapping("/cadastro")
    public ResponseEntity update(@RequestBody MedicamentoEntity medicamento){

        service.save(medicamento);

        MedicamentoDto medicamentoDto = new MedicamentoDto();
        medicamentoDto.setDados(medicamento);

        return new ResponseEntity<>(new MedicamentoDto(Response.SC_OK, "Medicamento atualizado com sucesso", medicamentoDto.getDados()), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity buscarTodosMedicamentos(){

        return service.buscarMedicamentos();
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/cadastro/{id}")
    public ResponseEntity deleById(@PathVariable("id") Long id){

        service.deleteById(id);
        DeleteDto delete = new DeleteDto(Response.SC_OK, "Medicamento deletado com seucesso!");
        return new ResponseEntity<>(delete, HttpStatus.OK);

    }
}
