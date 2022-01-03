package com.eatandplay.academicmanagementsystem.params.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/** common response. */
@Data
@AllArgsConstructor
public class CommonResp {
  private int code;
  private String message;

  public static CommonResp ok(String msg) {
    return new CommonResp(0, msg);
  }
}
