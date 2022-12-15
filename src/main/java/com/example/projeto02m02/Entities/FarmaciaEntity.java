package com.example.projeto02m02.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "farmacia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmaciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String razaoSocial;

    @NotNull
    private String cnpj;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    private String telefone;
    @NotNull
    private String celular;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private EnderecoEntity idEndereço;
}
