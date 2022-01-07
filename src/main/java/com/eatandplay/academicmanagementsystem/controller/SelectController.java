package com.eatandplay.academicmanagementsystem.controller;

import com.eatandplay.academicmanagementsystem.model.SelectRelation;
import com.eatandplay.academicmanagementsystem.params.req.SelectReq;
import com.eatandplay.academicmanagementsystem.params.resp.CommonResp;
import com.eatandplay.academicmanagementsystem.params.resp.Page;
import com.eatandplay.academicmanagementsystem.params.resp.SelectDto;
import com.eatandplay.academicmanagementsystem.service.SelectService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectController {

  private final SelectService selectService;

  public SelectController(
      SelectService selectService) {
    this.selectService = selectService;
  }

  /**
   * 学生选课
   *
   * @param req 选课参数
   * @return result
   */
  @Operation(method = "PUT", summary = "学生选课")
  @PutMapping("/select")
  public CommonResp select(@RequestBody SelectReq req) {
    SelectRelation selectRelation = new SelectRelation(req.getStudentId(), req.getCourseId());
    if (selectService.select(selectRelation)) {
      return CommonResp.ok(String.format("学生 %s 选课 %s", req.getStudentId(), req.getCourseId()));
    }
    return null;
  }

  /**
   * @param studentId id
   * @param courseId  id
   * @return result
   */
  @Operation(method = "GET", summary = "查询选课信息")
  @GetMapping("/select")
  public SelectDto selectInfo(int studentId, int courseId) {
    return selectService.selectInfo(studentId, courseId);
  }

  /**
   * @param page page
   * @param size size
   * @return result
   */
  @Operation(method = "GET", summary = "查询选课信息分页")
  @GetMapping("/select/list")
  public Page<List<SelectDto>> list(int page, int size) {
    int count = selectService.count();
    return new Page<>(page, size, count, selectService.list(page, size));
  }

}
