package org.qf.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传递给前端的的json格式对象类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {

    //状态码
    private int code;

    private String msg;  //提示信息

    private Object data;   //数据


}
