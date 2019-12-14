package undestiny.validationdemo.customAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;




/**
 * 性别约束
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeConstraintValidator.class)
public @interface Age {

	//Age参数值最大最小范围
	int max() default 150;
	int min() default 0;
	
    String message() default "年龄不在合法范围";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
