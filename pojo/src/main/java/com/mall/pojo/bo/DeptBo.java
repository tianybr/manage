package com.mall.pojo.bo;

import com.google.common.collect.Multimap;
import com.mall.pojo.validateBo.ValidateDept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author bryin
 * @create 2020-05-23 16:41
 */
@ApiModel("部门参数")
@Data
@ValidateDept
public class DeptBo {

    @ApiModelProperty("部门id")
    private Integer id;

    @ApiModelProperty("部门名称")
    private String name;
    @ApiModelProperty("父级部门id")
    private Integer parentId = 0;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("部门所在当前部门顺序")
    private Integer seq;
}
