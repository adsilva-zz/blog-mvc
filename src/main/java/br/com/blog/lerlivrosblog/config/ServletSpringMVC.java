package br.com.blog.lerlivrosblog.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Classe para configurar o Dispatcher 
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Mapeamento das classe que deve ser lida durante o carregamento da aplicação
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppWebConfiguration.class, JPAConfiguration.class };
	}

	// Mapeamento padrão dos endereços
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
