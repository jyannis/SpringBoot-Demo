package undestiny.springboot;

import org.springframework.context.annotation.Bean;
import undestiny.springboot.config.ConfigBean;

public class MyConfig2 {

    @Bean
    ConfigBean configBean(){
        System.out.println("------->bean2 初始化(flag==false)");
        return new ConfigBean();
    }
}
