package com.eatandplay.academicmanagementsystem.params.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * common response
 *
 * @author tuxzx
 */
@Data
@AllArgsConstructor
public class CommonResp {
  private int code;
  private String message;

  /**
   * @param msg msg
   * @return CommonResp
   */
  public static CommonResp of(String msg) {
    return new CommonResp(0, msg);
  }
}
