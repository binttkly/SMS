package org.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.qf.dao.CourseDao;
import org.qf.entity.Course;
import org.qf.service.CourseService;
import org.qf.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {
    //业务层：1.调用dao层  2.进行业务层逻辑判断

    @Autowired
    private CourseDao courseDao;



    //查询
    @Override
    public ResultVo showList1(String name,int pageNum) {
        //设置页面容量
        PageHelper.startPage(pageNum,5);
        List<Course> list = courseDao.showList1(name);
        PageInfo<Course> pageInfo=new PageInfo<Course>(list);
        if(pageInfo.getList().size()>0) {
            return new ResultVo(200, "查询成功", pageInfo);
        }else{
            return new ResultVo(201,"查询失败",null);
        }
    }

    /**
     * 添加用户
     * 1. 先根据用户名查询用户是否存在
     * 2. 如果存在，给出错误的提示
     *    如果不存在，插入数据
     */
    @Override
    public ResultVo addCourse(Course course) {
        Course selectCourse = courseDao.getCourseByName(course.getName());
        if(selectCourse==null){
            //可以添加
            courseDao.addCourse(course);
            return new ResultVo(502,"添加成功",null);
        }else{
            //给出错误提示
            return new ResultVo(501,"课程名已存在",null);
        }
    }

    @Override
    public ResultVo deleteCourseById(Integer courseId) {
        courseDao.deleteCourseById(courseId);
        return new ResultVo(200,"删除成功",null);
    }

    @Override
    public ResultVo updateCourse(Course course) {
        courseDao.updateCourse(course);
        return new ResultVo(200,"编辑成功",null);
    }

}
