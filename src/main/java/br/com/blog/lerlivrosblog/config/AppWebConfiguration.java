package br.com.blog.lerlivrosblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.blog.lerlivrosblog.controller.HomeController;
import br.com.blog.lerlivrosblog.model.Postagem;
import br.com.blog.lerlivrosblog.repository.PostagemRepositorioDAOImpl;
import br.com.blog.lerlivrosblog.service.PostagemServicoImpl;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, Postagem.class, PostagemServicoImpl.class,
		PostagemRepositorioDAOImpl.class }) // Informa qual é o pacote base para ser percorrido
public class AppWebConfiguration {

	@Bean // Mapea aonde as páginas deven ser encontradas
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
}
