package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    //根据条件查询课程信息
    public List<Course> findAllCourse(CourseVO courseVO);

    //新增课程信息
    public void saveCourseOrTeacher(CourseVO courseVO);

    //根据课程ID查询课程信息
    public CourseVO findCourseById(int id);

    //更新课程信息
    public void updateCourseOrTeacher(CourseVO courseVO);

    //修改课程状态
    public void updateCourseStatus(int id,int status);
}
