package br.com.emailsenderapi.service;

import br.com.emailsenderapi.dto.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailService {

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private JavaMailSender envioDeEmail;

    private static final Logger LOGGER = LoggerFactory.getLogger(EnviarEmailService.class);


    public void enviar(EmailDto email) throws Exception {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        try {
            LOGGER.info("Enviando email para: " + email.getDestinatario());
            mensagem.setFrom(remetente);
            mensagem.setTo(email.getDestinatario());
            mensagem.setSubject(email.getTitulo());
            mensagem.setText(email.getTexto());
            envioDeEmail.send(mensagem);

        }catch (Exception ex){
            throw ex;
        }
    }
}
