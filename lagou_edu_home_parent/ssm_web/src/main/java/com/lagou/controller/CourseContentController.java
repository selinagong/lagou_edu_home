package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(int courseId){
        List<CourseSection> courseSectionList = courseContentService.findSectionAndLesson(courseId);
        return new ResponseResult(true,200,"success",courseSectionList);
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(int courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",courseId);
        map.put("courseName",course.getCourseName());
        return new ResponseResult(true,200,"success",map);
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section){
        if (section.getId() == null) {
            courseContentService.saveSection(section);
        }else {
            courseContentService.updateSection(section);
        }
        return new ResponseResult(true,200,"success",null);
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id,int status){
        courseContentService.updateSectionStatus(id, status);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"success",map);
    }

    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson lesson){
        if (lesson.getId() == null) {
            courseContentService.saveLesson(lesson);
        }else {
            courseContentService.updateLesson(lesson);
        }
        return new ResponseResult(true,200,"success",null);
    }
}
