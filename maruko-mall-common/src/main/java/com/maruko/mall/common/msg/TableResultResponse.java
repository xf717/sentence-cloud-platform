package com.maruko.mall.common.msg;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-14 22:40
 */
public class TableResultResponse<T> extends BaseResponse {

	TableData<T> data;

	public TableResultResponse(long total, List<T> rows) {
		this.data = new TableData<>(total, rows);
	}

	public TableResultResponse(long total, int pages, List<T> rows) {
		this.data = new TableData<>(total, pages, rows);
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

	class TableData<T> {
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
				this.extend = Maps.newHashMap();
			}

			this.extend.put(key, value);
		}

		public void putAllExtend(Map<? extends String, ?> map) {
			if (this.extend == null) {
				this.extend = Maps.newHashMap();
			}

			this.extend.putAll(map);
		}

		public void removeExtend(String key) {
			if (this.extend == null) {
				this.extend = Maps.newHashMap();
			}

			this.extend.remove(key);
		}

		public boolean exist(String key) {
			if (this.extend == null) {
				this.extend = Maps.newHashMap();
			}

			return this.extend.containsKey(key);
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("super", super.toString()).append("data", data).toString();
	}
}
