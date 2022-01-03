package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Student;
import com.eatandplay.academicmanagementsystem.repository.StudentMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Student Service
 *
 * @author tuxzx
 */
@Service
public class StudentService {

  private final StudentMapper studentMapper;

  public StudentService(StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
  }

  /**
   * 通过id查询学生信息
   *
   * @param studentId id
   * @return Student
   */
  public Student queryStudentById(Integer studentId) {
    return studentMapper.findById(studentId);
  }

  /**
   * 添加学生
   *
   * @param student student
   */
  public void addStudent(Student student) {
    studentMapper.addStudent(student);
  }

  /**
   * 编辑学生信息
   *
   * @param student student
   */
  public void editStudent(Student student) {
    studentMapper.editStudent(student);
  }

  /**
   * 删除学生
   *
   * @param id id
   */
  public void deleteStudent(int id) {
    studentMapper.deleteStudent(id);
  }

  /**
   * 分页查询
   *
   * @param pageNum pageNum
   * @param size size
   * @return 学生列表
   */
  public List<Student> list(int pageNum, int size) {
    return studentMapper.findAll(size, pageNum == 0 ? pageNum : size * pageNum);
  }

  /**
   * 查询学生个数
   *
   * @return count
   */
  public int count() {
    return studentMapper.count();
  }
}
