package com.example.projeto02m02.Controllers;

import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Services.FarmaciaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {
    private FarmaciaService service;

    public FarmaciaController (FarmaciaService service){
        this.service = service;
    }
    @PostMapping
    public void salvaFarmaciaEendereco(@RequestBody FarmaciaEntity farmacia){
        service.saveFarmacia(farmacia);
    }
}
