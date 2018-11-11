package ca.boston.hack.buddysquad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class IntegratedSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegratedSpringApplication.class, args);
	}
}
