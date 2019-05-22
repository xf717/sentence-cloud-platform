package com.maruko.mall.common.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author xiaofeng
 * @date 2017/6/11
 */
public class ObjectRestResponse<T> extends BaseResponse {

	T data;
	boolean rel;

	public boolean isRel() {
		return rel;
	}

	public void setRel(boolean rel) {
		this.rel = rel;
	}


	public ObjectRestResponse rel(boolean rel) {
		this.setRel(rel);
		return this;
	}


	public ObjectRestResponse data(T data) {
		this.setData(data);
		return this;
	}

	public ObjectRestResponse() {
		super();
	}

	public ObjectRestResponse(int status, String message) {
		super(status, message);
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("super", super.toString()).append("data", data).append("rel", rel)
				.toString();
	}

}
