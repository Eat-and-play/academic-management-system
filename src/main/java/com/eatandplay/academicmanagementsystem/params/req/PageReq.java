package com.eatandplay.academicmanagementsystem.params.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分页
 *
 * @author tuxzx
 */
@Data
@AllArgsConstructor
public class PageReq {

  @Schema(title = "页码", required = true)
  private int page;

  @Schema(title = "大小", required = true)
  private int size;

  /**
   * @param pageNum pageNum
   * @param size    size
   * @return Page Object
   */
  public static PageReq of(int pageNum, int size) {
    return new PageReq(pageNum, size);
  }
}
