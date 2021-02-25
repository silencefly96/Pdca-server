package com.fundark.pdca.mapper;

import com.fundark.pdca.bean.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，
// 所以统一配置@MapperScan在扫描路径在application类中
public interface TaskMapper {

    //查
    @Select("SELECT * FROM tb_task WHERE id = #{id}")
    Task getTaskById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_task")
    public List<Task> getTaskList();

    //增
    @Insert("insert into tb_task(id,state,filter,type,start_time,duration,end_time,title,content) " +
            "values(#{id},#{state},#{filter},#{type},#{startTime},#{duration},#{endTime},#{title},#{content})")
    public int add(Task task);

    //删
    @Delete("delete from tb_task where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_task set " +
            "id=#{task.id}," +
            "state=#{task.state}," +
            "filter=#{task.filter}," +
            "type=#{task.type}," +
            "start_time=#{task.startTime}," +
            "duration=#{task.duration}," +
            "end_time=#{task.endTime}," +
            "title=#{task.title}," +
            "content=#{task.content} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("task") Task task);

}
