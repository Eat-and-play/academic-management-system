package com.eatandplay.academicmanagementsystem.repository;

import com.eatandplay.academicmanagementsystem.model.SelectRelation;
import com.eatandplay.academicmanagementsystem.params.resp.SelectDto;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 选课数据访问对象
 *
 * @author tuxzx
 */
@Mapper
public interface SelectMapper {

  /**
   * @param selectRelation 选课实体
   * @return 执行结果
   */
  @Insert("INSERT INTO t_select (student_id, course_id) VALUES (#{studentId}, #{courseId})")
  boolean save(SelectRelation selectRelation);

  /**
   * @param studentId id
   * @param courseId  id
   * @return result
   */
  @Select("SELECT s.id, s.name, c.id, c.name FROM t_select t "
      + "LEFT JOIN t_student s on s.id = t.student_id "
      + "LEFT JOIN t_course c on c.id = t.course_id "
      + "where t.student_id = #{studentId} and t.course_id = #{courseId}")
  Optional<SelectDto> findById(Integer studentId, Integer courseId);

  /**
   * 分页查询
   *
   * @param limit  limit
   * @param offset offset
   * @return result
   */
  @Select(
      "SELECT s.id student_id, s.name student_name, c.id course_id, c.name course_name FROM t_select t "
          + "LEFT JOIN t_student s on s.id = t.student_id "
          + "LEFT JOIN t_course c on c.id = t.course_id "
          + "limit #{limit} offset #{offset}")
  List<SelectDto> findAll(int limit, int offset);

  /**
   * 查询总个数
   *
   * @return count
   */
  @Select("SELECT COUNT(*) FROM t_select")
  int count();
}
