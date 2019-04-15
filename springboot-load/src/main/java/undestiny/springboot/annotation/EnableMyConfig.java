package undestiny.springboot.annotation;

import org.springframework.context.annotation.Import;
import undestiny.springboot.MyConfig;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({MyConfig.class})//导入MyConfig配置
public @interface EnableMyConfig {

}
