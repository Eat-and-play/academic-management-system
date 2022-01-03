package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.entity.Course;
import com.eatandplay.academicmanagementsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Course Controller.
 */
@Controller
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  /**
   * 通过id查询用户信息.
   *
   * @param id id
   * @return course
   */
  @GetMapping("/Course/{id}")
  @ResponseBody
  public Course courseInfo(@PathVariable("id") Integer id) {
    return courseService.queryCourseById(id);
  }
}
