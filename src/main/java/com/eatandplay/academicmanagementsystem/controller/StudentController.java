package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.model.Student;
import com.eatandplay.academicmanagementsystem.params.req.AddStudentReq;
import com.eatandplay.academicmanagementsystem.params.req.PageReq;
import com.eatandplay.academicmanagementsystem.params.resp.CommonResp;
import com.eatandplay.academicmanagementsystem.params.resp.Page;
import com.eatandplay.academicmanagementsystem.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student Controller
 *
 * @author tuxzx
 */
@Tag(name = "Student")
@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * 通过id查询用户信息
   *
   * @param id id
   * @return student
   */
  @Operation(method = "GET", summary = "通过Id查询Student")
  @GetMapping("/student/{id}")
  public Student studentInfo(@PathVariable("id") Integer id) {
    return studentService.queryStudentById(id);
  }

  /**
   * 添加Student
   *
   * @param addStudentReq req
   * @return id
   */
  @Operation(method = "PUT", summary = "增加Student")
  @PutMapping("/student")
  public CommonResp addStudent(@RequestBody AddStudentReq addStudentReq) {
    Student student = Student.of(addStudentReq.getName());
    studentService.addStudent(student);
    return CommonResp.ok(String.format("学生 Id: %s 添加成功", student.getId()));
  }

  /**
   * 修改Student信息
   *
   * @param id id
   * @param addStudentReq req
   * @return id
   */
  @Operation(method = "POST", summary = "修改Student")
  @PostMapping("/student/{id}")
  public CommonResp editStudent(
      @PathVariable("id") Integer id, @RequestBody AddStudentReq addStudentReq) {
    Student student = new Student(id, addStudentReq.getName(), null, null);
    studentService.editStudent(student);
    return CommonResp.ok(String.format("学生 Id: %s 信息修改成功", student.getId()));
  }

  /**
   * 删除Student
   *
   * @param id id
   * @return student
   */
  @Operation(method = "DELETE", summary = "删除Student")
  @DeleteMapping("/student/{id}")
  public CommonResp deleteStudent(@PathVariable("id") Integer id) {
    studentService.deleteStudent(id);
    return CommonResp.ok(String.format("学生 Id: %s 信息删除成功", id));
  }

  /**
   * 分页查询 Student
   *
   * @param pageReq req
   * @return list
   */
  @Operation(method = "GET", summary = "查询所有学生")
  @GetMapping("/student/list")
  public Page<List<Student>> list(PageReq pageReq) {
    int count = studentService.count();
    List<Student> result = studentService.list(pageReq.getPageNum(), pageReq.getSize());
    return new Page<>(pageReq.getPageNum(), pageReq.getSize(), count, result);
  }
}
