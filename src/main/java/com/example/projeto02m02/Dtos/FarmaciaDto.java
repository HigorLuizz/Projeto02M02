package com.example.projeto02m02.Dtos;

import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Entities.MedicamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmaciaDto {
    private int statusCode;

    private String mensagem;

    private FarmaciaEntity dados;
}
