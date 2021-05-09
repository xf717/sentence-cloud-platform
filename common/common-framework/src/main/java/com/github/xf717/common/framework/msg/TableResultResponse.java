package com.github.xf717.common.framework.msg;

import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 分页TableResultResponse
 *
 * @author xiaofeng
 * @create 2017-06-14 22:40
 */
public class TableResultResponse<T> extends BaseResponse {

  TableData<T> data;

  public TableResultResponse(long total, List<T> rows) {
    this.data = new TableData<>(total, rows);
    this.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
  }

  public TableResultResponse(long total, int pages, List<T> rows) {
    this.data = new TableData<>(total, pages, rows);
    this.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
  }

  public TableResultResponse(TableData<T> tableData) {
    this.data = tableData;
  }

  public TableResultResponse() {
    this.data = new TableData<>();
  }

  TableResultResponse<T> total(int total) {
    this.data.setTotal(total);
    return this;
  }

  TableResultResponse<T> total(List<T> rows) {
    this.data.setRows(rows);
    return this;
  }

  public TableData<T> getData() {
    return data;
  }

  public void setData(TableData<T> data) {
    this.data = data;
  }


  @Override
  public String toString() {
    return new ToStringBuilder(this).append("super", super.toString()).append("data", data)
        .toString();
  }

}
