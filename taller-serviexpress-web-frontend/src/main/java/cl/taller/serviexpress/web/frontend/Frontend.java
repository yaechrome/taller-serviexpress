package cl.taller.serviexpress.web.frontend;

import java.util.Arrays;

import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath*:META-INF/spring/cl/taller/serviexpress/web/frontend/beans.xml")
// @ComponentScan(basePackages = { "cl.junji.control.normativo.**" })
public class Frontend {

	public static void main(String[] args) {
		SpringApplication.run(Frontend.class, args);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setTomcatContextCustomizers(Arrays.asList(new CustomCustomizer()));
		return factory;
	}

	static class CustomCustomizer implements TomcatContextCustomizer {
		@Override
		public void customize(Context context) {
			context.setUseHttpOnly(true);
		}
	}
}
