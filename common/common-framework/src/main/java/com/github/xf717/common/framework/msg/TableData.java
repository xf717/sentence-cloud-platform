package com.github.xf717.common.framework.msg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页数据
 *
 * @author XIAOFENG
 */
public class TableData<T> {

  long total;
  int pages;
  List<T> rows;
  Map<String, Object> extend;

  public TableData(long total, List<T> rows) {
    this.total = total;
    this.rows = rows;
  }

  public TableData(long total, int pages, List<T> rows) {
    this.total = total;
    this.pages = pages;
    this.rows = rows;
  }

  public TableData(long total, List<T> rows, Map<String, Object> extend) {
    this.total = total;
    this.rows = rows;
    this.extend = extend;
  }

  public TableData() {
  }

  public TableData(Map<String, Object> extend) {
    this.extend = extend;
  }

  public long getTotal() {
    return this.total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public int getPages() {
    return this.pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public List<T> getRows() {
    return this.rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }

  public Map<String, Object> getExtend() {
    return this.extend;
  }

  public void putExtend(String key, Object value) {
    if (this.extend == null) {
      this.extend = new HashMap<>(10);
    }

    this.extend.put(key, value);
  }

  public void putAllExtend(Map<? extends String, ?> map) {
    if (this.extend == null) {
      this.extend = new HashMap<>(10);
    }

    this.extend.putAll(map);
  }

  public void removeExtend(String key) {
    if (this.extend == null) {
      this.extend = new HashMap<>(10);
    }

    this.extend.remove(key);
  }

  public boolean exist(String key) {
    if (this.extend == null) {
      this.extend = new HashMap<>(10);
    }

    return this.extend.containsKey(key);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TableData{");
    sb.append("total=").append(total);
    sb.append(", pages=").append(pages);
    sb.append(", rows=").append(rows);
    sb.append(", extend=").append(extend);
    sb.append('}');
    return sb.toString();
  }
}

