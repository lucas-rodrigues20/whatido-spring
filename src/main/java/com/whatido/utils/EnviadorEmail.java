package com.whatido.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.whatido.models.Contato;
import com.whatido.models.Usuario;
import com.whatido.utils.freemarker.FreemarkerConfig;

@Component
public class EnviadorEmail {
	
	@Autowired
	private JavaMailSenderImpl mailer;
	
	@Autowired
	private FreemarkerConfig freemarkerConfig;
	
	public void enviarEmailUsuario(Usuario usuario, String assunto, TipoEmail tipoEmail){
		try {
			MimeMessage message = mailer.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, "UTF-8");
			
			String msg = freemarkerConfig.getEmailComTemplate(usuario, tipoEmail);
		
			mimeMessageHelper.setText(msg, true);
			mimeMessageHelper.setSubject(assunto);
			mimeMessageHelper.setFrom("agendatarefas@outlook.com");
			mimeMessageHelper.setTo(usuario.getEmail());
			
			mailer.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enviarEmailContato(Contato contato){
		try {
			MimeMessage message = mailer.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, "UTF-8");
			
			String msg = freemarkerConfig.getEmailComTemplate(contato, TipoEmail.CONTATO);
			
			mimeMessageHelper.setText(msg, true);
			mimeMessageHelper.setSubject(contato.getAssunto());
			mimeMessageHelper.setFrom("agendatarefas@outlook.com");
			mimeMessageHelper.setTo("lrpg_doidao@hotmail.com");
			
			mailer.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
