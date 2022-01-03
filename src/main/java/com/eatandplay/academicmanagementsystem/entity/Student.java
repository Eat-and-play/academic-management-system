package com.eatandplay.academicmanagementsystem.entity;

import java.time.LocalDateTime;
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

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  public static Student of(Integer id, String name) {
    LocalDateTime now = LocalDateTime.now();
    return new Student(id, name, now, now);
  }
}