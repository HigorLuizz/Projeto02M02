package com.example.projeto02m02.Exepitions;

import com.example.projeto02m02.Dtos.DefaultError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApplicationExcepitionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleExceptionNoFindId(Exception e){

        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Não existe esse dado!","Provavelmente você requisitou um dado que não existe no sistema. Tente outra requisição");

        return new ResponseEntity(erro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){

        DefaultError defaultError = new DefaultError(HttpStatus.BAD_REQUEST.value(),"Um erro ocorreu","Um erro ocorreu no sistema, revise os dados requeridos e as ações tomadas e tente novamente!");

        return new ResponseEntity("error", HttpStatus.BAD_REQUEST);
    }

}
