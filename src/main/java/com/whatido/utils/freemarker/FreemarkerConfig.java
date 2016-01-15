package com.whatido.utils.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.whatido.utils.TipoEmail;
import com.whatido.utils.freemarker.templates.TemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class FreemarkerConfig {
	
	private Configuration getFreemarkerConfig() throws IOException, URISyntaxException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setClassForTemplateLoading(TemplateLoader.class, "");
		cfg.setDefaultEncoding("UTF-8");

		return cfg;
	}
	
	public String getEmailComTemplate(Object parametro, TipoEmail tipoEmail) throws Exception {
		try {
			Configuration cfg = getFreemarkerConfig();
			Template tmplt = cfg.getTemplate(tipoEmail.getDescricao());

			// Insere parametros
			Map<String, Object> data = new HashMap<>();
			data.put("parametro", parametro);

			// Constroi a saida
			Writer out = new StringWriter();
			tmplt.process(data, out);

			return out.toString();
		} catch (IOException | URISyntaxException | TemplateException e) {
			e.printStackTrace();
			throw new Exception("O template do email não pode ser processado.");
		}
	}

}
