package demo.primenumbers.primenumbersgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

 
@SpringBootApplication
 //@EnableJpaRepositories(basePackages={"demo.primenumbers.primenumbersgen.repository"})
public class PrimenumbersgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimenumbersgenApplication.class, args);
                  System.out.println("App is up..");
	}

}
