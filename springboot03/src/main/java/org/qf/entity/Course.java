package org.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //相当于生成了get和set方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造函数
public class Course {
    //属性
    private int id;  //课程编号

    private String name;  //课程名称

    private String profession;  //专业

    private String room;  //上课教室

    private String teacher;  //授课老师


}
