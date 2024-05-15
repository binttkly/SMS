package org.qf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.qf.entity.Course;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface CourseDao {


    /**
     * 查询操作
     * @return
     */
    public List<Course> showList1(String name);

    /**
     * 根据课程名查询课程信息
     *
     */
    Course getCourseByName(String name);

    /**
     * 添加课程信息
     */
    void addCourse(Course course);

    //    根据id删除课程信息
    void deleteCourseById(Integer courseId);

    //    修改课程信息
    void updateCourse(Course course);
}
