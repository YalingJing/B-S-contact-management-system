package com.Jingyalin.mapper;

import com.Jingyalin.entity.Dept;
import com.Jingyalin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DeptMapper {
    int addDept(Dept dept);
    int deleteById(Integer deptno);
    int updateDeptById(Dept dept);
    List<Dept> findAllDept(@Param("keywords") String keywords);
    List<Menu> loadAllMenu();
}
