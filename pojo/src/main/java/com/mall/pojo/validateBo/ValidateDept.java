package com.mall.pojo.validateBo;

import com.mall.pojo.validateImpl.ValidateBoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author bryin
 * @create 2020-05-23 16:52
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ValidateBoImpl.class)
public @interface ValidateDept {
    String message() default "参数有误";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
