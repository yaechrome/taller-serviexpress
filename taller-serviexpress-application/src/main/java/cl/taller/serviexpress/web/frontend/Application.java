package cl.taller.serviexpress.web.frontend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;


@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
	
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}
}
