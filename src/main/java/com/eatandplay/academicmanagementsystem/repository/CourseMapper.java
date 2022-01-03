package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Course;
import org.apache.ibatis.annotations.*;

/** Course Mapper. */
@Mapper
public interface CourseMapper {
  @Select("SELECT * FROM t_course WHERE id = #{id}")
  Course findById(@Param("id") Integer id);
}
