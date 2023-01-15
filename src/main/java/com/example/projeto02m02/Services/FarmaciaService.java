package com.example.projeto02m02.Services;

import com.example.projeto02m02.Dtos.FarmaciasDto;
import com.example.projeto02m02.Dtos.MedicamentosDto;
import com.example.projeto02m02.EnderecoViaCep;
import com.example.projeto02m02.Entities.EnderecoEntity;
import com.example.projeto02m02.Entities.FarmaciaEntity;
import com.example.projeto02m02.Entities.MedicamentoEntity;
import com.example.projeto02m02.Feign.FeignClient;
import com.example.projeto02m02.Repositories.EnderecoRepository;
import com.example.projeto02m02.Repositories.FarmaciaRepository;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {
    private final FeignClient feign;
    private FarmaciaRepository farmaciaRepository;

    private EnderecoRepository enderecoRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository, FeignClient feign, EnderecoRepository enderecoRepository) {
        this.farmaciaRepository = farmaciaRepository;
        this.feign = feign;
        this.enderecoRepository = enderecoRepository;

    }

    public void saveFarmacia(FarmaciaEntity farmacia){
        EnderecoViaCep evc= feign.buscaCep(farmacia.getIdEndereco().getCep());
        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .cep(farmacia.getIdEndereco().getCep())
                .numero(farmacia.getIdEndereco().getNumero())
                .bairro(evc.getBairro())
                .complemento(farmacia.getIdEndereco().getComplemento())
                .uf(evc.getUf())
                .localidade(evc.getBairro())
                .logradouro(evc.getLogradouro())
                .latitude(farmacia.getIdEndereco().getLatitude())
                .longitude(farmacia.getIdEndereco().getLongitude())
                .build();
        enderecoRepository.save(enderecoEntity);
        farmaciaRepository.save(FarmaciaEntity.builder()
                        .celular(farmacia.getCelular())
                        .cnpj(farmacia.getCnpj())
                        .email(farmacia.getEmail())
                        .nome(farmacia.getNome())
                        .razaoSocial(farmacia.getRazaoSocial())
                        .telefone(farmacia.getTelefone())
                        .idEndereco(enderecoEntity)
                .build());

    }
    public ResponseEntity buscarFarmacias(){

        if (farmaciaRepository.findAll().isEmpty()) {
            throw new NullPointerException();
        }else{
            List<FarmaciaEntity> farmacias = farmaciaRepository.findAll();

            FarmaciasDto farmaciasDto = new FarmaciasDto();

            return new ResponseEntity(new FarmaciasDto(Response.SC_FOUND,"Medicamentos escontrados!",farmacias), HttpStatus.FOUND);

        }

    }
    public FarmaciaEntity findById(Long id){
        if(farmaciaRepository.findById(id).isPresent()){
            return farmaciaRepository.findById(id).get();
        }else{
            throw new NullPointerException();
        }

    }

    public void deleteById(Long id){
        farmaciaRepository.deleteById(id);
    }
}
