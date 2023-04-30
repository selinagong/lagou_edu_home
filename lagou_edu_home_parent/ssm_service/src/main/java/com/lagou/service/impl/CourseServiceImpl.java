package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse(CourseVO courseVO) {
        return courseMapper.findAllCourse(courseVO);
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {
        //保存课程信息
        Course course = new Course();
        BeanUtils.copyProperties(courseVO,course);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);
        int id = course.getId();

        //保存讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(courseVO,teacher);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);
        courseMapper.saveTeacher(teacher);
    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        //更新课程信息
        Course course = new Course();
        BeanUtils.copyProperties(courseVO,course);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);

        //更新讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(courseVO,teacher);
        teacher.setUpdateTime(date);
        teacher.setCourseId(course.getId());
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int id,int status) {
        Course course = new Course();
        course.setUpdateTime(new Date());
        course.setId(id);
        course.setStatus(status);
        courseMapper.updateCourseStatus(course);
    }


}
