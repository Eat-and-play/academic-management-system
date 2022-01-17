package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.Course;
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
  Optional<Course> findById(@Param("id") Integer id);


  /**
   * 添加课程
   *
   * @param course course
   */
  @Insert("INSERT INTO t_course (name, create_time, update_time)"
      + "VALUES (#{name}, #{createTime}, #{updateTime})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void addCourse(Course course);


  /**
   * 修改课程
   *
   * @param course course
   */
  @Update("UPDATE t_course set name = #{name} where id = #{id}")
  void editCourse(Course course);

  /**
   * 删除课程
   *
   * @param id id
   */
  @Delete("DELETE FROM t_course where id = #{id}")
  void deleteCourse(int id);

  /**
   * 分页查询
   *
   * @param limit  limit
   * @param offset offset
   * @return course list
   */
  @Select("SELECT * FROM t_course limit #{limit} offset #{offset}")
  List<Course> findAll(int limit, int offset);

  /**
   * 查询总个数
   *
   * @return count
   */
  @Select("SELECT COUNT(*) FROM t_course")
  int count();
}
