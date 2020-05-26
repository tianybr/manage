package com.mall.pojo.vo;

import com.google.common.collect.Lists;
import com.mall.pojo.Dept;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-24 16:15
 */
@Data
public class DeptVo extends Dept {
    private List<DeptVo> children = Lists.newArrayList();
    public static DeptVo adapt(Dept dept){
        DeptVo deptVo = new DeptVo();
        BeanUtils.copyProperties(dept, deptVo);
        return deptVo;
    }
}
