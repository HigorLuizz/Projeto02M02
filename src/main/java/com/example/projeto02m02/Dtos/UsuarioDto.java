package com.example.projeto02m02.Dtos;

import com.example.projeto02m02.Entities.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private int statusCode;

    private String mensagem;

    private UsuarioEntity dados;
}
