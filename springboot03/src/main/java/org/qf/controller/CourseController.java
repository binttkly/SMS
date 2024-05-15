package org.qf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.qf.entity.Course;
import org.qf.service.CourseService;
import org.qf.utils.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

//@Controller   //控制器
//@RestController// === @Controller+ @ResponseBody   //异步请求控制器
@Controller //: mvc中的控制层，定义接口，springmvc的接口只能返回路径【前端路径、接口路径】，不能返回对象
@Api(value = "提供了课程查询等相关的接口",tags = "课程管理")
@CrossOrigin   // 允许跨域
public class CourseController {
    //调用业务层
    @Resource
    private CourseService courseService;


    //查询功能
    @GetMapping("/showList1")
    @ApiOperation(value = "课程查询接口")
    @ResponseBody
    public ResultVo showList1(String name,@RequestParam(defaultValue = "1") int pageNum){
        System.out.println(name+"=====================");
        System.out.println(pageNum+"========================");
        ResultVo resultVo = courseService.showList1(name, pageNum);
        System.out.println(resultVo);
        return resultVo;
    }

    /**
     * 添加课程信息
     * @RequestBody: 接收前端传递的json对象
     */
    @PostMapping("/addCourse")
    @ApiOperation(value = "课程添加接口")
    @ResponseBody //给前端返回json对象
    //请求头中的content-type:规定接口传递参数的类型  例如：application/json
    public ResultVo addCourse(@RequestBody Course course){
        System.out.println(course);
        return courseService.addCourse(course);
    }
    /**
     * 根据课程id删除数据
     * 前端： http://localhost:8080/deleteCourse/2
     */
    @GetMapping("/deleteCourse/{id}")
    @ResponseBody
    public ResultVo deleteCourse(@PathVariable("id") Integer courseId){
        System.out.println("要删除的课程id>>>>>"+courseId);
        return courseService.deleteCourseById(courseId);
    }
    /**
     * 编辑课程信息
     */
    @PostMapping("/updateCourse")
    @ResponseBody
    public ResultVo updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }


}
