package com.eatandplay.academicmanagementsystem.params.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuxzx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectDto {
  private int studentId;
  private int courseId;
  private String studentName;
  private String courseName;
}
