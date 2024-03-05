package com.qiuxue.controller;

import com.qiuxue.pojo.PageBean;
import com.qiuxue.pojo.Result;
import com.qiuxue.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/emps")
    //@RequestParam这个注解可以设置默认参数
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询，参数：{}，{}",page,pageSize);

        //调用Service分页查询
        PageBean pageBean = empService.page(page,pageSize);

        return Result.success(pageBean);
    }
}
