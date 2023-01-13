package com.example.projeto02m02.Controllers;

import com.example.projeto02m02.Dtos.FarmaciaDto;
import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Services.FarmaciaService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {
    private FarmaciaService service;

    public FarmaciaController (FarmaciaService service){
        this.service = service;
    }
    @PostMapping("/cadastro")
    public ResponseEntity salvaFarmaciaEendereco(@RequestBody FarmaciaEntity farmacia){
        service.saveFarmacia(farmacia);
        FarmaciaDto farmaciaDto = new FarmaciaDto();
        farmaciaDto.setDados(farmacia);

        return new ResponseEntity<>(new FarmaciaDto(Response.SC_OK, "Farmácia  criada com sucesso", farmaciaDto.getDados()), HttpStatus.CREATED);
    }

    @PutMapping("/cadastro")
    public void atualizaFarmaciaEendereco(@RequestBody FarmaciaEntity farmacia){
        service.saveFarmacia(farmacia);
    }
    @GetMapping
    public List<FarmaciaEntity> buscarTodosMedicamentos(){
        return service.buscarFarmacias();
    }

    @GetMapping("/{id}")
    public FarmaciaEntity findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/cadastro/{id}")
    public void deleById(@PathVariable("id") Long id){
        service.deleteById(id);
    }
}
