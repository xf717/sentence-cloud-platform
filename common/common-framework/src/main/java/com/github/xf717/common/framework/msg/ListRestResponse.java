package com.github.xf717.common.framework.msg;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-09 7:32
 */
@Deprecated
public class ListRestResponse<T> extends BaseResponse {

  List<T> result;
  int count;

  public ListRestResponse() {
    super();
  }

  public ListRestResponse(int status, String message) {
    super(status, message);
  }

  public static ListRestResponse failure(int status, String message) {
    return new ListRestResponse(status, message);
  }

  public List<T> getResult() {
    return this.result;
  }

  public void setResult(List<T> result) {
    this.result = result;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public ListRestResponse count(int count) {
    this.setCount(count);
    return this;
  }

  public ListRestResponse count(Long count) {
    this.setCount(count.intValue());
    return this;
  }

  public ListRestResponse result(List<T> result) {
    this.setResult(result);
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("super", super.toString()).append("result", result)
        .append("count", count).toString();
  }

}
