package com.lagou.service;

import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    //根据课程ID查询章节与课时信息
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);
}
