package com.example.projeto02m02.Entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String cep;


    private String logradouro;


    private String numero;


    private String bairro;


    private String localidade;


    private String uf;


    private String latitude;


    private String longitude;

    private String complemento;
}
