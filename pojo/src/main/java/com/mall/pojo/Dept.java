package com.mall.pojo;

import com.mall.pojo.validateBo.ValidateDept;
import lombok.Data;

import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-23 16:42
 */
@Data
public class Dept {
    private Integer id;
    private String name;
    private Integer parentId;
    private String level;
    private Integer seq;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;
}
