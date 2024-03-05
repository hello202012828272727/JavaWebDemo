package com.qiuxue.controller;

import com.qiuxue.pojo.Dept;
import com.qiuxue.pojo.Result;
import com.qiuxue.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门数据
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("获取部门：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
