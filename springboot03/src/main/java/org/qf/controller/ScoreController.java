package org.qf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.qf.entity.Score;
import org.qf.service.ScoreService;
import org.qf.utils.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

//@Controller   //控制器
//@RestController// === @Controller+ @ResponseBody   //异步请求控制器
@Controller //: mvc中的控制层，定义接口，springmvc的接口只能返回路径【前端路径、接口路径】，不能返回对象
@Api(value = "提供了分数查询等相关的接口",tags = "成绩管理")
@CrossOrigin   // 允许跨域
public class ScoreController {

    //调用业务层
    @Resource
    private ScoreService scoreService;

    //查询功能
    @GetMapping("/showList2")
    @ApiOperation(value = "成绩查询接口")
    @ResponseBody
    public ResultVo showList2(String name, @RequestParam(defaultValue = "1") int pageNum){
        System.out.println(name+"=====================");
        System.out.println(pageNum+"========================");
        ResultVo resultVo = scoreService.showList2(name, pageNum);
        System.out.println(resultVo);
        return resultVo;
    }

    /**
     * 添加用户
     * @RequestBody: 接收前端传递的json对象
     */
    @PostMapping("/addScore")
    @ApiOperation(value = "成绩添加接口")
    @ResponseBody //给前端返回json对象
    //请求头中的content-type:规定接口传递参数的类型  例如：application/json
    public ResultVo addScore(@RequestBody Score score){
        System.out.println(score);
        return scoreService.addScore(score);
    }
    /**
     * 根据用户id删除数据
     * 前端： http://localhost:8080/deleteScore/2
     */
    @GetMapping("/deleteScore/{id}")
    @ResponseBody
    public ResultVo deleteScore(@PathVariable("id") Integer id){
        System.out.println("要删除的用户id>>>>>"+id);
        return scoreService.deleteScoreById(id);
    }
    /**
     * 编辑用户信息
     */
    @PostMapping("/updateScore")
    @ResponseBody
    public ResultVo updateScore(@RequestBody Score score){
        return scoreService.updateScore(score);
    }
}
