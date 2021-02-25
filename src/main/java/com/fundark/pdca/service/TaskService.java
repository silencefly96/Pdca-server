package com.fundark.pdca.service;

import com.fundark.pdca.bean.Task;

import java.util.List;

public interface TaskService {

    //通过id查询
    Task getTaskById(Integer id);

    //获取用户列表
    public List<Task> getTaskList();

    //增
    public int add(Task task);

    //删
    public int delete(Integer id);

    //改
    public int update( Integer id, Task task);

}
