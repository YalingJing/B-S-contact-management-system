package com.Jingyalin.service;

import com.Jingyalin.entity.Dept;
import com.Jingyalin.entity.Menu;

import java.util.List;


public interface DeptService {
    int addDept(Dept dept);
    int deleteById(Integer id);
    int updateDeptById(Dept dept);
    List<Dept> findAllDept(String keywords);
    List<Menu> loadAllMenu();
}
