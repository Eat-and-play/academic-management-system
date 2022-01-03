package com.eatandplay.academicmanagementsystem.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** Student Entity. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

  private Integer id;

  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  public static Student of(Integer id, String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Student(id, name, now, now);
  }
}
