package undestiny.springboot.annotation;

import org.springframework.context.annotation.Import;
import undestiny.springboot.MyConfigSelector;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({MyConfigSelector.class})
public @interface EnableMyConfigSelector {

    boolean flag() default false;

}
