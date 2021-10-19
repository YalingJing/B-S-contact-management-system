package com.Jingyalin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.Jingyalin.entity.Dept;
import com.Jingyalin.entity.Menu;
import com.Jingyalin.entity.RespBean;
import com.Jingyalin.entity.RespPageBean;
import com.Jingyalin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param keywords
     * @return
     */
    @GetMapping("/")
    public RespPageBean findAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords){
        PageHelper.startPage(page, size);
        List<Dept> list = deptService.findAllDept(keywords);
        PageInfo pageInfo = new PageInfo(list);
        RespPageBean bean = new RespPageBean();
        bean.setData(pageInfo.getList());
        bean.setTotal(pageInfo.getTotal());
        return bean;
    }

    /**
     * 删除
     * @param deptno
     * @return
     */
    @DeleteMapping("/{deptno}")
    public RespBean deleteDept(@PathVariable Integer deptno){

       if(deptService.deleteById(deptno)==1){
            return RespBean.DELETE_SUCCESS;//删除成功
       }
        return RespBean.DELETE_ERROR;//删除失败
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("/")
    public RespBean addDept(@RequestBody Dept dept){
        if(deptService.addDept(dept)==1){
            return RespBean.ADD_SUCCESS;//添加成功
        }
        return RespBean.ADD_ERROR;//添加失败
    }

    /**
     * 更新
     * @param dept
     * @return
     */
    @PutMapping("/")
    public RespBean updateDept(@RequestBody Dept dept){
         if(deptService.updateDeptById(dept)==1){
              return RespBean.UPDATE_SUCCESS;//添加成功
           }
        return RespBean.UPDATE_ERROR;//添加失败
    }

    @RequestMapping("/menu")
    public Object menu(){
        List<Menu> menus = deptService.loadAllMenu();
        Map<String,Object> map=new HashMap<>();

        for (Menu menu : menus) {

            map.put(menu.getTypecode(),menu);
        }
        return map;
     //  return menus;
    }
}
