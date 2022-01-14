package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Student;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Student Mapper
 *
 * @author tuxzx
 */
@Mapper
public interface StudentMapper {

  /**
   * @param id id
   * @return Student
   */
  @Select("SELECT * FROM t_student WHERE id = #{id}")
  Optional<Student> findById(@Param("id") Integer id);

  /**
   * 添加学生
   *
   * @param student student
   */
  @Insert(
      "INSERT INTO t_student (name, create_time, update_time) "
          + "VALUES ( #{name}, #{createTime}, #{updateTime})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void addStudent(Student student);

  /**
   * 更新学生
   *
   * @param student student
   */
  @Update("UPDATE t_student set name = #{name} where id = #{id}")
  void editStudent(Student student);

  /**
   * 删除学生
   *
   * @param id id
   */
  @Delete("DELETE FROM t_student where id = #{id}")
  void deleteStudent(int id);

  /**
   * 分页查询
   *
   * @param limit  limit
   * @param offset offset
   * @return student list
   */
  @Select("SELECT * FROM t_student limit #{limit} offset #{offset}")
  List<Student> findAll(int limit, int offset);

  /**
   * 查询总个数
   *
   * @return count
   */
  @Select("SELECT COUNT(*) FROM t_student")
  int count();
}
