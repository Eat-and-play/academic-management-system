package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Course;
import com.eatandplay.academicmanagementsystem.repository.CourseMapper;
import org.springframework.stereotype.Service;

/** Course Service. */
@Service
public class CourseService {
  private final CourseMapper courseMapper;

  public CourseService(CourseMapper courseMapper) {
    this.courseMapper = courseMapper;
  }

  public Course queryCourseById(Integer courseId) {
    return courseMapper.findById(courseId);
  }
}
