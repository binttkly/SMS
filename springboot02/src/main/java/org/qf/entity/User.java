package org.qf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data   //相当于生成了get和set方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造函数
public class User {

    //属性
    private int id;  //编号

    private String name;  //名称

    private String sex;  //性别

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;  //出生日期

    private String phone;  //电话

    private String address;  //地址

    private String password;  //密码
}
