package com.example.projeto02m02.Dtos;

import com.example.projeto02m02.Entities.MedicamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentosDto {
    private int statusCode;

    private String mensagem;

    private List<MedicamentoEntity> dados;
}
