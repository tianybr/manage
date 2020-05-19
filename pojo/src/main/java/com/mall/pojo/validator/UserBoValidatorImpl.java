package com.mall.pojo.validator;

import com.mall.pojo.bo.UserBo;
import com.mall.pojo.validator.annotation.UserBoValidator;
import com.mysql.jdbc.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author bryin
 * @create 2020-05-18 21:46
 */
public class UserBoValidatorImpl implements ConstraintValidator<UserBoValidator, UserBo> {
    @Override
    public boolean isValid(UserBo userBo, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("密码不能为空")
                .addConstraintViolation();

        return !StringUtils.isNullOrEmpty(userBo.getPassword());
    }
}
