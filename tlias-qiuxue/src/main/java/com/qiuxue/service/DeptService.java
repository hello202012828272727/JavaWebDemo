package com.qiuxue.service;

import com.qiuxue.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     *
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);
    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
