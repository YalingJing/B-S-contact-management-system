package com.Jingyalin.service.serviceimpl;

import com.Jingyalin.entity.Dept;
import com.Jingyalin.entity.Menu;
import com.Jingyalin.mapper.DeptMapper;
import com.Jingyalin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return deptMapper.updateDeptById(dept);
    }

    @Override
    public List<Dept> findAllDept(String keywords) {
        return deptMapper.findAllDept(keywords);
    }

    @Override
    public List<Menu> loadAllMenu() {
        return deptMapper.loadAllMenu();
    }
}
