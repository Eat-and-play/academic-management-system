package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.model.Student;
import com.eatandplay.academicmanagementsystem.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/** Student Controller. */
@Tag(name = "Student")
@Controller
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * 通过id查询用户信息.
   *
   * @param id id
   * @return student
   */
  @Operation(
          method = "GET",
          summary = "通过Id查询Student"
  )
  @GetMapping("/student/{id}")
  @ResponseBody
  public Student studentInfo(@PathVariable("id") Integer id) {
    return studentService.queryStudentById(id);
  }
}
