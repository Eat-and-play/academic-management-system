package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Student;
import com.eatandplay.academicmanagementsystem.repository.StudentMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/** Student Service. */
@Service
public class StudentService {

  private final StudentMapper studentMapper;

  public StudentService(StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
  }

  public Student queryStudentById(Integer studentId) {
    return studentMapper.findById(studentId);
  }

  public void addStudent(Student student) {
    studentMapper.addStudent(student);
  }

  public void editStudent(Student student) {
    studentMapper.editStudent(student);
  }

  public void deleteStudent(int id) {
    studentMapper.deleteStudent(id);
  }

  public List<Student> list(int pageNum, int size) {
    return studentMapper.findAll(size, pageNum == 0 ? pageNum : size * pageNum);
  }

  public int count() {
    return studentMapper.count();
  }
}
