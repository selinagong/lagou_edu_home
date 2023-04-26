package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.util.List;

public interface CourseMapper {

    //根据条件查询课程信息
    public List<Course> findAllCourse(CourseVO courseVO);
}
