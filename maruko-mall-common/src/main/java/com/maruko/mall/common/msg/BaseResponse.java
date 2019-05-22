package com.maruko.mall.common.msg;

import com.maruko.mall.common.enums.StatusEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author ace
 * @date 2017/8/23
 * @update xiaofeng
 */
public class BaseResponse {
	private int status = 200;
	private String message;

	public BaseResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public BaseResponse() {
	}

	public static BaseResponse success(String message) {
		return new BaseResponse(StatusEnum.SUCCESS.getStatus(), message);
	}

	public static BaseResponse failure(String message) {
		return new BaseResponse(StatusEnum.FAILURE.getStatus(), message);
	}

	/**
	 * 失败，自定义状态值
	 *
	 * @param status
	 * @param message
	 * @return
	 */
	public static BaseResponse failure(int status, String message) {
		return new BaseResponse(status, message);
	}

	public boolean isSuccess() {
		return status == StatusEnum.SUCCESS.getStatus();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("status", status).append("message", message).toString();
	}


}
