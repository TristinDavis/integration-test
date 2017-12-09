package name.karwowski.blazej.integrationdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class IntegrationDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationDemo2Application.class, args);
	}
}
