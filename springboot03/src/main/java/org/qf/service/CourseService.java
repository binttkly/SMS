package org.qf.service;

import org.qf.entity.Course;
import org.qf.utils.ResultVo;

public interface CourseService {

    /**
     * 查询
     * @param name
     * @return
     */
    public ResultVo showList1(String name,int pageNum);

    /**
     * 添加用户
     * @param course
     * @return
     */
    ResultVo addCourse(Course course);

    ResultVo deleteCourseById(Integer courseId);

    ResultVo updateCourse(Course course);
}
