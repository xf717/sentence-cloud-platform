package com.github.xf717.common.framework.msg;

import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author xiaofeng
 * @date 2017/6/11
 */
public class ObjectRestResponse<T> extends BaseResponse {

  T data;

  public ObjectRestResponse data(T data) {
    this.setData(data);
    this.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
    this.setMessage("");
    return this;
  }

  public ObjectRestResponse() {
    super();
  }



  public ObjectRestResponse(int status, String message) {
    super(status, message);
  }

  public static <T> ObjectRestResponse success(T data) {
    return new ObjectRestResponse().data(data);
  }

  public static ObjectRestResponse failure(int status, String message) {
    return new ObjectRestResponse(status, message);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static void main(String[] args) {
    System.out.println(new ObjectRestResponse<String>());
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("super", super.toString()).append("data", data)
        .toString();
  }

}
