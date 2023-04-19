package pl.csanecki.AITSI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AitsiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AitsiApplication.class, args);
	}

}
