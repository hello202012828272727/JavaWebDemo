package com.qiuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiuxue.mapper.EmpMapper;
import com.qiuxue.pojo.Emp;
import com.qiuxue.pojo.PageBean;
import com.qiuxue.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> list = empMapper.page(start,pageSize);

        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Emp> emplist = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) emplist;
        //封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 批量删除操作
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
}
