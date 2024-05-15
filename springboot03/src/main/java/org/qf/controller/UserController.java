package org.qf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.qf.dto.DeleteBatchDTO;
import org.qf.entity.User1;
import org.qf.service.UserService;
import org.qf.utils.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

//@Controller   //控制器
//@RestController// === @Controller+ @ResponseBody   //异步请求控制器
@Controller //: mvc中的控制层，定义接口，springmvc的接口只能返回路径【前端路径、接口路径】，不能返回对象
@Api(value = "提供了用户登录、查询等相关的接口",tags = "用户管理")
@CrossOrigin   // 允许跨域
public class UserController {

    //调用业务层
    @Resource
    private UserService userService;

    //登录功能
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name ="name",value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name ="password",value = "用户登录密码",required = true)
    })
    @ResponseBody
    public ResultVo login(String name, String password){
        System.out.println(name);
        System.out.println(password);
         return userService.login(name, password);
    }

    //查询功能
    @GetMapping("/showList")
    @ApiOperation(value = "用户查询接口")
    @ResponseBody
    public ResultVo showList(String name,@RequestParam(defaultValue = "1") int pageNum){
        System.out.println(name+"=====================");
        System.out.println(pageNum+"========================");
        ResultVo resultVo = userService.showList(name, pageNum);
        System.out.println(resultVo);
        return resultVo;
    }

    /**
     * 添加用户
     * @RequestBody: 接收前端传递的json对象
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "用户添加接口")
    @ResponseBody //给前端返回json对象
    //请求头中的content-type:规定接口传递参数的类型  例如：application/json
    public ResultVo addUser(@RequestBody User1 user){
        System.out.println(user);
        return userService.addUser(user);
    }
    /**
     * 根据用户id删除数据
     * 前端： http://localhost:8080/deleteUser/2
     */
    @GetMapping("/deleteUser/{id}")
    @ResponseBody
    public ResultVo deleteUser(@PathVariable("id") Integer userId){
        System.out.println("要删除的用户id>>>>>"+userId);
        return userService.deleteUserById(userId);
    }
    /**
     * 编辑用户信息
     */
    @PostMapping("/updateUser")
    @ResponseBody
    public ResultVo updateUser(@RequestBody User1 user){
        return userService.updateUser(user);
    }

    /**
     * 批量删除
     * 接收前端传递的数组
     * entity,domain,pojo,bean:实体类
     * vo:view object  视图层对象【返回给前端的对象】
     * DTO:接收前端传递参数的复合对象
     * TO:服务与服务之间传递的对象
     */
    @PostMapping("/deleteBatch")
    @ResponseBody
    public ResultVo deleteBatch(@RequestBody DeleteBatchDTO deleteBatchDTO){
        return userService.deleteBatch(deleteBatchDTO.getIdList());
    }
}
