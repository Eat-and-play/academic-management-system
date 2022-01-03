package com.eatandplay.academicmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** Course Entity. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

  private int id;

  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  public static Course of(Integer id, String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Course(id, name, now, now);
  }
}
