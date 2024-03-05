package com.qiuxue.service.impl;

import com.qiuxue.mapper.EmpMapper;
import com.qiuxue.pojo.Emp;
import com.qiuxue.pojo.PageBean;
import com.qiuxue.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //获取总记录数
        Long count = empMapper.count();
        //获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> list = empMapper.page(start,pageSize);
        //封装PageBean对象
        PageBean pageBean = new PageBean(count,list);
        return pageBean;
    }
}
