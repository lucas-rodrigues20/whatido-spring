package com.whatido.conf;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.whatido.controllers.HomeController;
import com.whatido.daos.ListasDAO;
import com.whatido.utils.SegurancaUtils;
import com.whatido.utils.freemarker.FreemarkerConfig;
import com.whatido.validators.NovaSenhaValidator;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ListasDAO.class, LoginDetailsService.class,
		SegurancaUtils.class, NovaSenhaValidator.class, FreemarkerConfig.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("/WEB-INF/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);

        return messageSource;
    }
	
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost("smtp.live.com");
		javaMailSenderImpl.setPort(587);
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		
		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		
		javaMailSenderImpl.setUsername("agendatarefas@outlook.com");
		javaMailSenderImpl.setPassword("projetoagenda1");
		
		return javaMailSenderImpl;
	}

}
