package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    //根据课程ID查询章节与课时信息
    public List<CourseSection> findSectionAndLesson(int courseId);

    //章节对应的课程信息
    public Course findCourseByCourseId(int courseId);

    //保存章节信息
    public void saveSection(CourseSection section);

    //修改章节信息
    public void updateSection(CourseSection section);

    //修改章节状态
    public void updateSectionStatus(int id,int status);

    //新建课时信息
    public void saveLesson(CourseLesson lesson);
}
