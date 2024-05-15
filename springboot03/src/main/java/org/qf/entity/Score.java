package org.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //相当于生成了get和set方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造函数
public class Score {

    private int id;  //序号

    private String studentName; //学生姓名

    private String no;  //学生账号

    private String name;  //课程名称

    private int score;  //分数

    private int term;  //学期

    private String year;  //学年
}
