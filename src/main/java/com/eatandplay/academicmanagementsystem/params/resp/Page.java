package com.eatandplay.academicmanagementsystem.params.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分页对象
 *
 * @param <T> T
 * @author tuxzx
 */
@Data
@AllArgsConstructor
public class Page<T> {
  private int pageNum;
  private int size;
  private int count;
  private T data;
}
