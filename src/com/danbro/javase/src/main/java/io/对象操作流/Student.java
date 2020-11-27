package io.对象操作流;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2020/8/18 11:45
 * @Author Danrbo
 */
@Data
@AllArgsConstructor
public class Student implements Serializable {
    private Integer id;
    private String name;
}
