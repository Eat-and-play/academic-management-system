package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/** Student Mapper. */
@Mapper
public interface StudentMapper {

  @Select("SELECT * FROM t_student WHERE id = #{id}")
  Student findById(@Param("id") Integer id);
}
