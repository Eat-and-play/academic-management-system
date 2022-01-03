package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Student;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/** Student Mapper. */
@Mapper
public interface StudentMapper {

  @Select("SELECT * FROM t_student WHERE id = #{id}")
  Student findById(@Param("id") Integer id);

  @Insert(
      "INSERT INTO t_student (name, create_time, update_time) "
          + "VALUES ( #{name}, #{createTime}, #{updateTime})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void addStudent(Student student);

  @Update("UPDATE t_student set name = #{name} where id = #{id}")
  void editStudent(Student student);

  @Select("SELECT * FROM t_student limit #{limit} offset #{offset}")
  @Options()
  List<Student> findAll(int limit, int offset);

  @Select("SELECT COUNT(*) FROM t_student")
  int count();
}
