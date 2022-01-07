package com.eatandplay.academicmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectRelation {

  private Integer studentId;

  private Integer courseId;
}
