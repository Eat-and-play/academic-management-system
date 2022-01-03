package com.eatandplay.academicmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** Student Entity. */
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

  /**
   * Student .
   *
   * @param name name
   * @param createTime time
   * @param updateTime time
   */
  public Student(String name, LocalDateTime createTime, LocalDateTime updateTime) {
    this.name = name;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  public static Student of(String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Student(name, now, now);
  }
}
