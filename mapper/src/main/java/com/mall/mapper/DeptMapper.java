package com.mall.mapper;

import com.mall.pojo.Dept;
import com.mall.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-23 17:13
 */
@Repository
public interface DeptMapper {
    void add(Dept dept);
    Dept selectDeptByPrimaryKey(Integer deptId);
    Integer countDeptByParentIdAndName(@Param("parentId") Integer parentId, @Param("deptName") String deptName, @Param("deptId") Integer deptId);
    List<Dept> getAllDept();
    void update(Dept dept);
    void del(@Param("id") Integer id);
    Integer selectDeptByParentId(@Param("parentId") Integer parentId);
}
