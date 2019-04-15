package undestiny.springboot;

import org.springframework.context.annotation.Bean;
import undestiny.springboot.config.ConfigBean;

public class MyConfig {

    @Bean
    ConfigBean configBean(){
        System.out.println("------->bean 初始化");
        return new ConfigBean();
    }
}
