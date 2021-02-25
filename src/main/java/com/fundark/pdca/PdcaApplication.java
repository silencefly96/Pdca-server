package com.fundark.pdca;

import com.fundark.pdca.mapper.TaskMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = TaskMapper.class)
public class PdcaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdcaApplication.class, args);
    }

}
