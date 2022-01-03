package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.Student;
import com.eatandplay.academicmanagementsystem.repository.StudentMapper;
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
}
