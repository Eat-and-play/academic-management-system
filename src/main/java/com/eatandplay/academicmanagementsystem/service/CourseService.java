package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Course;
import com.eatandplay.academicmanagementsystem.repository.CourseMapper;
import org.springframework.stereotype.Service;

/**
 * Course Service
 *
 * @author GongZeqing
 */
@Service
public class CourseService {
  private final CourseMapper courseMapper;

  public CourseService(CourseMapper courseMapper) {
    this.courseMapper = courseMapper;
  }

  /**
   * @param courseId id
   * @return Course
   */
  public Course queryCourseById(Integer courseId) {
    return courseMapper.findById(courseId);
  }
}
