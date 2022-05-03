package br.com.emailsenderapi.controller;

import br.com.emailsenderapi.dto.EmailDto;
import br.com.emailsenderapi.service.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
public class EnviarEmailController {

    @Autowired
    private EnviarEmailService service;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void enviarEmailTexto(@RequestBody @Valid EmailDto emailDto) throws Exception{
        service.enviar(emailDto);
    }
}
