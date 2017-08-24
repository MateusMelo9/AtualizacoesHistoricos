package br.com.cfi;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
@EnableAutoConfiguration
public class AtualizacoesHistoricosApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(AtualizacoesHistoricosApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
}
