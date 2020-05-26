package com.mall.pojo.validateImpl;

import com.mall.pojo.bo.DeptBo;
import com.mall.pojo.validateBo.ValidateDept;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @author bryin
 * @create 2020-05-23 16:55
 */
@Slf4j
public class ValidateBoImpl implements ConstraintValidator<ValidateDept, DeptBo> {

    @Override
    public void initialize(ValidateDept constraintAnnotation) {

    }

    @Override
    public boolean isValid(DeptBo deptBo, ConstraintValidatorContext context) {
        String deptName = deptBo.getName();
        Integer seq = deptBo.getSeq();
        String errorMsg = "";
        if (StringUtils.isBlank(deptName)) {

            errorMsg += "部门名称不能为空;";
        }
        if (seq == null) {
            errorMsg += "部门顺序不能为空;";
        }
        if ("".equals(errorMsg)) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMsg).addConstraintViolation();
        return false;

    }
}
