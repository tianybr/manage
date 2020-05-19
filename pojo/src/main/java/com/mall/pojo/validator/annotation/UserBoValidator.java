package com.mall.pojo.validator.annotation;

import com.mall.pojo.validator.UserBoValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author bryin
 * @create 2020-05-18 21:38
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserBoValidatorImpl.class)
public @interface UserBoValidator {
    String message() default "参数不合法";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
