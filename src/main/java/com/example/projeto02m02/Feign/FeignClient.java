package com.example.projeto02m02.Feign;


import com.example.projeto02m02.EnderecoViaCep;
import com.example.projeto02m02.Entities.EnderecoEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(url="https://viacep.com.br/ws/", name = "hello")
public interface FeignClient {
    @GetMapping("{cep}/json")
    EnderecoViaCep buscaCep(@PathVariable("cep") String cep);

    @PostMapping("{cep}/json")
    String buscaCep(@RequestBody() EnderecoEntity cep);
}
