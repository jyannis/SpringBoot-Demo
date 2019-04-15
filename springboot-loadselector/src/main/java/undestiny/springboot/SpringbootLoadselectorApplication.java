package undestiny.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import undestiny.springboot.annotation.EnableMyConfigSelector;

@EnableMyConfigSelector(flag = false)
@SpringBootApplication
public class SpringbootLoadselectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoadselectorApplication.class, args);
	}

}
