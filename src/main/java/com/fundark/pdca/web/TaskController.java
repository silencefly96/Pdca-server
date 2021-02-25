package com.fundark.pdca.web;

import com.fundark.pdca.bean.JsonResult;
import com.fundark.pdca.bean.Task;
import com.fundark.pdca.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 根据ID查询任务
     * @param id 查询ID
     * @return 任务
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "task/query/{id}")
    public Task getTaskById(@PathVariable(value = "id") Integer id){
        try {
            Task task = taskService.getTaskById(id);
            return task;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 查询任务列表
     * @return 任务列表
     */
    @RequestMapping(value = "tasks/query",method = RequestMethod.GET)
    public List<Task> getTaskList(){

        try {
            List<Task> tasks = taskService.getTaskList();
            return tasks;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 添加任务
     * @param task 任务
     * @return 结果
     */
    @RequestMapping(value = "task/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add(@RequestBody Task task){
        JsonResult r = new JsonResult();
        try {
            int orderId = taskService.add(task);
            if (orderId < 0){
                r.setResult(orderId);
                r.setStatus("failed");
            }else {
                r.setResult(orderId);
                r.setStatus("ok");
            }

        }catch (Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除任务
     * @param id 任务id
     * @return 结果
     */
    @RequestMapping(value = "task/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id){
        JsonResult r=new JsonResult();

        try {
            int delId = taskService.delete(id);
            if (delId < 0){
                r.setResult(delId);
                r.setStatus("failed");
            }else {
                r.setResult(delId);
                r.setStatus("ok");
            }
        }catch (Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改task信息
     * @param task 任务
     * @return 结果
     */
    @RequestMapping(value = "task/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable(value = "id") Integer id,
                                             @RequestBody Task task){
        JsonResult r=new JsonResult();
        try {
            int ret = taskService.update(id, task);
            if (ret<0){
                r.setResult(ret);
                r.setStatus("fail");
            }else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        }catch (Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

}
