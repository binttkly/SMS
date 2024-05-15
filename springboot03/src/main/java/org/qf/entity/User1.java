package org.qf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 实体类:orm框架映射,将数据库表映射为具体的实体类
 *
 * 一张表映射为一个实体类，一般表中的字段就是类的属性。
 *
 * java的三大特征:封装：(保证类的安全性，1.属性私有化   2.提供方法(生成get和set方法))  继承  多态
 *
 * lombok:实体类的第三方插件
 */
@Data   //相当于生成了get和set方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造函数
public class User1 {

    //属性
   private int id;  //编号

   private String name;  //名称

    private int age;  //年龄

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;  //出生日期

    private String phone;  //电话

   private String address;  //地址

    private String password;  //密码

    private int price;  //工资
}
