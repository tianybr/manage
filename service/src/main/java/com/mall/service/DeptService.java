package com.mall.service;

import com.mall.pojo.bo.DeptBo;
import com.mall.pojo.vo.DeptVo;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-23 17:17
 */

public interface DeptService {
    void add(DeptBo deptBo);
    List<DeptVo> getDept();
    void update(DeptBo deptBo);
    void del(Integer id);
}
