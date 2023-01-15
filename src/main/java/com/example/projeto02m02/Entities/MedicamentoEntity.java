package com.example.projeto02m02.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity (name = "medicamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nomelab;

    private String dosagem;

    private String descricao;

    private String precounitario;

    private String tipomedicamento;
}
