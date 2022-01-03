package com.eatandplay.academicmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student Entity
 *
 * @author tuxzx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private Integer id;

  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  public Student(String name, LocalDateTime createTime, LocalDateTime updateTime) {
    this.name = name;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  /**
   * @param name name
   * @return student
   */
  public static Student of(String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Student(name, now, now);
  }
}
