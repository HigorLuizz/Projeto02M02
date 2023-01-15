package com.example.projeto02m02.Dtos;

import com.example.projeto02m02.Entities.FarmaciaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmaciaByIdDto {
    private int statusCode;

    private String mensagem;

    private Optional dado;
}
