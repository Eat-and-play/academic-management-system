package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Course Mapper
 *
 * @author GongZeQing
 */
@Mapper
public interface CourseMapper {

  /**
   * @param id id
   * @return Course
   */
  @Select("SELECT * FROM t_course WHERE id = #{id}")
  Course findById(@Param("id") Integer id);
}
