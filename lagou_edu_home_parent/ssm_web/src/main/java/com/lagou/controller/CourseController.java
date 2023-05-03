package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //根据条件查询课程信息
    @RequestMapping("/findAllCourse")
    public ResponseResult findAllCourse(CourseVO courseVO) {
        List<Course> courseList = courseService.findAllCourse(courseVO);
        return new ResponseResult(true,200,"success",courseList);
    }

    //新增课程信息
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO){
        if (courseVO.getId() == null) {
            courseService.saveCourseOrTeacher(courseVO);
        }else {
            courseService.updateCourseOrTeacher(courseVO);
        }
        return new ResponseResult(true, 200, "success", null);
    }

    //根据课程ID查询课程信息
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(int id) {
        CourseVO course = courseService.findCourseById(id);
        return new ResponseResult(true,200,"success",course);
    }

    //修改课程状态
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(int id,int status){
        courseService.updateCourseStatus(id,status);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"success",map);
    }

}
