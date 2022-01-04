package com.eatandplay.academicmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Course Entity
 *
 * @author GongZeqing
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  private int id;

  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  public Course(String name, LocalDateTime createTime, LocalDateTime updateTime) {
    this.name = name;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  /**
   * @param name name
   * @return Course
   */
  public static Course of(String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Course(name, now, now);
  }
}
