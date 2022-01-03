package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.model.Course;
import com.eatandplay.academicmanagementsystem.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Course Controller.
 */
@Tag(name = "Course")
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
  @Operation(
          method = "GET",
          summary = "通过Id查询Course"
  )
  @GetMapping("/Course/{id}")
  @ResponseBody
  public Course courseInfo(@PathVariable("id") Integer id) {
    return courseService.queryCourseById(id);
  }
}
