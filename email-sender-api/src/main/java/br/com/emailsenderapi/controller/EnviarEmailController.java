package br.com.emailsenderapi.controller;

import br.com.emailsenderapi.service.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/email")
public class EnviarEmailController {

    @Autowired
    private EnviarEmailService service;

    @GetMapping(value = "/enviar-texto")
    public void enviarEmailTexto(String destinatario, String titulo ,String texto) throws Exception{
        service.enviar(destinatario, titulo, texto);
    }

    @GetMapping(value = "/enviar-arquivo")
    public void enviarEmailArquivo(String destinatario, String titulo ,String arquivo) throws Exception{
        service.enviarPdf(destinatario, titulo, arquivo);
    }

    @GetMapping(value = "/enviar-texto-arquivo")
    public void enviarEmailTextoEArquivo(String destinatario, String titulo ,String texto, String arquivo) throws Exception{
        service.enviarTextoEPdf(destinatario, titulo,texto, arquivo);
    }

}
