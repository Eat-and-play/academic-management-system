package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/** Course Mapper. */
@Mapper
public interface CourseMapper {
  @Select("SELECT * FROM t_course WHERE id = #{id}")
  Course findById(@Param("id") Integer id);
}
