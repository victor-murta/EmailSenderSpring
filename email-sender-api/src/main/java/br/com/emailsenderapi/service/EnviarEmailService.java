package br.com.emailsenderapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnviarEmailService {

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private JavaMailSender envioDeEmail;


    public void enviar(String destinatario, String titulo ,String texto) throws Exception {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        try {
            log.info("Enviando email para: ", destinatario);
            mensagem.setFrom(remetente);
            mensagem.setFrom(destinatario);
            mensagem.setSubject(titulo);
            mensagem.setText(texto);
            envioDeEmail.send(mensagem);
        }catch (Exception ex){
            throw ex;
        }
    }

    public void enviarPdf(String destinatario, String titulo ,String arquivo) throws Exception {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        EmailAttachment messageHelper = new MimeMessageHelper();

        try {
            log.info("Enviando email para: ", destinatario);
            mensagem.setFrom(remetente);
            mensagem.setFrom(destinatario);
            mensagem.setSubject(titulo);
            messageHelper.addAttachment("arquivo", new ClassPathResource(arquivo));
            envioDeEmail.send(mensagem);
        }catch (Exception ex){
            throw ex;
        }
    }

    public void enviarTextoEPdf(String destinatario, String titulo ,String texto, String arquivo) throws Exception {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper();

        try {
            log.info("Enviando email para: ", destinatario);
            mensagem.setFrom(remetente);
            mensagem.setFrom(destinatario);
            mensagem.setSubject(titulo);

            messageHelper.addAttachment("arquivo", new ClassPathResource(arquivo));
            mensagem.setText(texto);
            envioDeEmail.send(mensagem);
        }catch (Exception ex){
            throw ex;
        }
    }
}
