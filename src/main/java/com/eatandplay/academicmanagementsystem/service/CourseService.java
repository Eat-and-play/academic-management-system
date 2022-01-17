package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Course;
import com.eatandplay.academicmanagementsystem.repository.CourseMapper;
import java.util.List;
import java.util.Optional;
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
  public Optional<Course> queryCourseById(Integer courseId) {
    return courseMapper.findById(courseId);
  }


  /**
   * 添加课程
   *
   * @param course course
   */
  public void addCourse(Course course) {
    courseMapper.addCourse(course);
  }

  /**
   * 修改课程
   *
   * @param course course
   */
  public void editCourse(Course course) {
    courseMapper.editCourse(course);
  }

  /**
   * 删除课程
   *
   * @param id id
   */
  public void deleteCourse(Integer id) {
    courseMapper.deleteCourse(id);
  }

  /**
   * 分页查询
   *
   * @param pageNum pageNum
   * @param size    size
   * @return course
   */
  public List<Course> list(int pageNum, int size) {
    return courseMapper.findAll(size, pageNum == 0 ? pageNum : size * pageNum);
  }

  /**
   * 返回课程总数
   *
   * @return count
   */
  public int count() {
    return courseMapper.count();
  }


}
