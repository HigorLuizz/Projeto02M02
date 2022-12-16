package com.example.projeto02m02.Entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity(name = "farmacia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmaciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "razaosocial")
    private String razaoSocial;


    private String cnpj;


    private String nome;


    private String email;

    private String telefone;

    private String celular;


    @OneToOne
    @JoinColumn(name = "id_endereco")
    private EnderecoEntity idEndereco;
}
