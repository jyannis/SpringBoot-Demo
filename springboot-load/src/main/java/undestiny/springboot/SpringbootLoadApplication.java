package undestiny.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import undestiny.springboot.annotation.EnableMyConfig;

@SpringBootApplication
@EnableMyConfig//加载EnableMyConfig下的配置
public class SpringbootLoadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoadApplication.class, args);
	}

}
