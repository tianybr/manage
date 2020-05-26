package com.mall.controller.v1;

import com.mall.common.JSONResult;
import com.mall.pojo.bo.DeptBo;
import com.mall.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author bryin
 * @create 2020-05-23 16:09
 */
@RestController
@Api(tags = "部门接口")
@RequestMapping("v1/dept")
@Validated
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation("新增部门")
    @PostMapping("/add")
    public JSONResult add(@RequestBody @Valid DeptBo deptBo) {
        deptService.add(deptBo);
        return JSONResult.ok();
    }
    @ApiOperation("获取部门树级结构")
    @PostMapping("/getTreeDept")
    public JSONResult getTreeDept() {
        return JSONResult.ok(deptService.getDept());
    }
    @ApiOperation("更新部门树级结构")
    @PostMapping("/update")
    public JSONResult update(@RequestBody @Valid DeptBo deptBo) {
        deptService.update(deptBo);
        return JSONResult.ok();
    }
    @ApiOperation("删除部门")
    @GetMapping("/del")
    public JSONResult del(Integer id) {
        deptService.del(id);
        return JSONResult.ok();
    }
}
