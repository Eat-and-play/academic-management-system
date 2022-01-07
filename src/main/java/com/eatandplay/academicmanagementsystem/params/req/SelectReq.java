package com.eatandplay.academicmanagementsystem.params.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectReq {

  @Schema(name = "student_id", required = true)
  private int studentId;

  @Schema(name = "course_id", required = true)
  private int courseId;
}
