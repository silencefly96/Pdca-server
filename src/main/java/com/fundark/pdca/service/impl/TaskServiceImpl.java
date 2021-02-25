package com.fundark.pdca.service.impl;

import com.fundark.pdca.bean.Task;
import com.fundark.pdca.mapper.TaskMapper;
import com.fundark.pdca.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//如果有一个类带了@Service注解，将自动注册到Spring容器，不需要再在applicationContext里面定义bean了
@Service
public class TaskServiceImpl implements TaskService {

    //Autowired:把配置好的Bean拿来用，完成属性、方法的组装
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Task getTaskById(Integer id) {
        return taskMapper.getTaskById(id);
    }

    @Override
    public List<Task> getTaskList() {
        return taskMapper.getTaskList();
    }

    @Override
    public int add(Task task) {
        return taskMapper.add(task);
    }

    @Override
    public int delete(Integer id) {
        return taskMapper.delete(id);
    }

    @Override
    public int update(Integer id, Task task) {
        return taskMapper.update(id, task);
    }
}
