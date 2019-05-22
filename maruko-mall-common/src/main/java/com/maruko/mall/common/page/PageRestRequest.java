package com.maruko.mall.common.page;

/**
 * Title: <br>
 * Description: Copyright: Copyright (c) 2018
 *
 * @author xiaofeng 创建时间:2018/7/30 10:18
 */
public class PageRestRequest<T> implements java.io.Serializable {
	private static final long serialVersionUID = 2265565995976545293L;
	private T data;
	private Page<T> page;

	public PageRestRequest() {
	}

	public PageRestRequest(T data, Page<T> page) {
		this.data = data;
		this.page = page;
	}

	public PageRestRequest<T> data(T data) {
		this.data = data;
		return this;
	}

	public PageRestRequest<T> page(Page<T> page) {
		this.page = page;
		return this;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageRestRequest{" + "data=" + data + ", page=" + page + '}';
	}
}
