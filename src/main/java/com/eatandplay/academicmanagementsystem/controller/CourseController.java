package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.model.Course;
import com.eatandplay.academicmanagementsystem.params.req.AddCourseReq;
import com.eatandplay.academicmanagementsystem.params.req.PageReq;
import com.eatandplay.academicmanagementsystem.params.resp.CommonResp;
import com.eatandplay.academicmanagementsystem.params.resp.Page;
import com.eatandplay.academicmanagementsystem.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * Course Controller
 *
 * @author GongZeqing
 */
@CrossOrigin
@Tag(name = "Course")
@RestController
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  /**
   * 通过id查询用户信息
   *
   * @param id id
   * @return course
   */
  @Operation(method = "GET", summary = "通过Id查询Course")
  @GetMapping("/course/{id}")
  public Course courseInfo(@PathVariable("id") Integer id) {
    return courseService.queryCourseById(id);
  }



  /**
   * 添加Course
   *
   * @param addCourseReq req
   * @return id
   */
  @Operation(method = "PUT", summary = "增加Course")
  @PutMapping("/course")
  public CommonResp addCourse(@RequestBody AddCourseReq addCourseReq) {
    Course course = Course.of(addCourseReq.getName());
    courseService.addCourse(course);
    return CommonResp.ok(String.format("课程 Id: %s 添加成功", course.getId()));
  }

  /**
   * 修改Course信息
   *
   * @param id            id
   * @param addCourseReq req
   * @return id
   */
  @Operation(method = "POST", summary = "修改Course")
  @PostMapping("/course/{id}")
  public CommonResp editCourse(
      @PathVariable("id") Integer id, @RequestBody AddCourseReq addCourseReq) {
    Course course = new Course(id, addCourseReq.getName(), null, null);
    courseService.editCourse(course);
    return CommonResp.ok(String.format("学生 Id: %s 信息修改成功", course.getId()));
  }

  /**
   * 删除Course
   *
   * @param id id
   * @return Course
   */
  @Operation(method = "DELETE", summary = "删除Course")
  @DeleteMapping("/course/{id}")
  public CommonResp deleteCourse(@PathVariable("id") Integer id) {
    courseService.deleteCourse(id);
    return CommonResp.ok(String.format("课程 Id: %s 信息删除成功", id));
  }

  /**
   * 分页查询 Course
   *
   * @param pageReq req
   * @return list
   */
  @Operation(method = "GET", summary = "查询所有课程")
  @GetMapping("/course/list")
  public Page<List<Course>> list(PageReq pageReq) {
    int count = courseService.count();
    List<Course> result = courseService.list(pageReq.getPage(), pageReq.getSize());
    return new Page<>(pageReq.getPage(), pageReq.getSize(), count, result);
  }
}
