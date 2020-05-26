package com.mall.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mall.common.exception.ParamException;
import com.mall.common.utils.LevelUtils;
import com.mall.mapper.DeptMapper;
import com.mall.pojo.Dept;
import com.mall.pojo.bo.DeptBo;
import com.mall.pojo.vo.DeptVo;
import com.mall.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author bryin
 * @create 2020-05-23 17:18
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void add(DeptBo deptBo) {
        Integer parentId = deptBo.getParentId();
        if(parentId == null){
            parentId = 0;
            deptBo.setParentId(0);
        }

        if(checkDeptNameExist(parentId,deptBo.getName(),deptBo.getId())){
            throw new ParamException("部门已存在");
        }
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptBo, dept);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        dept.setOperateIp(requestAttributes.getRequest().getRemoteAddr() + ":" + requestAttributes.getRequest().getRemotePort());
        dept.setOperator("bryin");

        String patentLevel = getLevel(parentId);
        dept.setLevel(LevelUtils.calculateLevel(patentLevel,parentId));
        dept.setOperateTime(new Date());
        deptMapper.add(dept);
    }

    @Override
    public List<DeptVo> getDept() {
        List<Dept> allDept = deptMapper.getAllDept();
        List<DeptVo> deptVoList = Lists.newArrayList();
        allDept.forEach(dept -> {
            deptVoList.add(DeptVo.adapt(dept));
        });
        return deptListToTree(deptVoList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void update(DeptBo deptBo) {
        Integer parentId = deptBo.getParentId();
        if(parentId == null){
            parentId = 0;
            deptBo.setParentId(0);
        }

        Integer deptId = deptBo.getId();
        if(checkDeptNameExist(parentId,deptBo.getName(),deptBo.getId())){
            throw new ParamException("部门已存在");
        }
        if(deptId == null){
            throw new ParamException("部门id不能为空");
        }
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptBo, dept);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        dept.setOperateIp(requestAttributes.getRequest().getRemoteAddr() + ":" + requestAttributes.getRequest().getRemotePort());
        dept.setOperator("bryin");

        String patentLevel = getLevel(parentId);
        dept.setLevel(LevelUtils.calculateLevel(patentLevel,parentId));
        dept.setOperateTime(new Date());
        deptMapper.update(dept);
    }

    public List<DeptVo> deptListToTree(List<DeptVo> deptVoList){
        if(CollectionUtils.isEmpty(deptVoList)){
            return Lists.newArrayList();
        }

        Multimap<String,DeptVo> levelDeptMap = ArrayListMultimap.create();
        List<DeptVo> rootList = Lists.newArrayList();
        deptVoList.forEach(deptVo -> {
            levelDeptMap.put(deptVo.getLevel(),deptVo);
            if(LevelUtils.ROOT.equals(deptVo.getLevel())){
                rootList.add(deptVo);
            }
        });
//        (o1,o2)-> o1.getSeq() - o2.getSeq()
        Collections.sort(rootList, Comparator.comparingInt(Dept::getSeq));
        transformDeptTree(rootList,LevelUtils.ROOT,levelDeptMap);
        return rootList;
    }
    public void transformDeptTree(List<DeptVo> deptList,String deptLevel,Multimap<String,DeptVo> levelDeptMap){
        deptList.forEach(deptVo -> {
            String nextLevel = LevelUtils.calculateLevel(deptLevel, deptVo.getId());
            List<DeptVo> deptVos = (List<DeptVo>) levelDeptMap.get(nextLevel);
            Collections.sort(deptVos, Comparator.comparingInt(Dept::getSeq));
            deptVo.setChildren(deptVos);
            if(CollectionUtils.isNotEmpty(deptVos)){
                transformDeptTree(deptVos,nextLevel,levelDeptMap);
            }
        });
    }
    public Boolean checkDeptNameExist(Integer parentId,String deptName,Integer deptId){
        return deptMapper.countDeptByParentIdAndName(parentId,deptName,deptId) > 0;
    }
    public String getLevel(Integer deptId){
        if(deptId == null){
            return null;
        }
        Dept dept = deptMapper.selectDeptByPrimaryKey(deptId);
        if(dept == null){
            return null;
        }
        return dept.getLevel();
    }

    @Transactional
    @Override
    public void del(Integer id){
        if(deptMapper.selectDeptByPrimaryKey(id) == null){
            throw new ParamException("部门不存在,无法删除");
        }
        if(deptMapper.selectDeptByParentId(id)>0){
            throw new ParamException("当前部门下存在子部门,无法删除");
        }
        //TODO 查询部门下是否有人员
        deptMapper.del(id);
    }
}
