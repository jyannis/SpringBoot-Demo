package undestiny.validationdemo.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<Age, Integer> {

	private int realMax;
	private int realMin;

	//校验
    @Override
    public boolean isValid(Integer realValue, ConstraintValidatorContext context) {
        return realValue != null && (realValue >= realMin && realValue <= realMax);
    }

    //初始化（一般是提取参数）
	@Override
	public void initialize(Age constraintAnnotation) {
		//initialize
		realMax = constraintAnnotation.max();
		realMin = constraintAnnotation.min();
	}
}
