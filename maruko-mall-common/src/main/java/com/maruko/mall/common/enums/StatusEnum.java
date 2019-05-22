package com.maruko.mall.common.enums;


/**
 *
 * @author xiaofeng
 */

public enum StatusEnum {

	/**
	 * 服务器成功返回请求的数据
	 */
	SUCCESS(200, "成功"),
	/**
	 * 发出的请求有错误，服务器没有进行新建或修改数据的操作
	 */
	BAD_REQUEST(400, "没有进行新增或修改"),

	/**
	 * 用户没有权限（令牌、用户名、密码错误）
	 */
	NO_ENTRY(401, "用户没有权限"),

	/**
	 * 服务器发生错误
	 */
	FAILURE(500, "服务器发生错误");

	/**
	 *
	 201: '新建或修改数据成功。',
	 202: '一个请求已经进入后台排队（异步任务）。',
	 204: '删除数据成功。',
	 400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
	 401: '用户没有权限（令牌、用户名、密码错误）。',
	 403: '用户得到授权，但是访问是被禁止的。',
	 404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
	 406: '请求的格式不可得。',
	 410: '请求的资源被永久删除，且不会再得到的。',
	 422: '当创建一个对象时，发生一个验证错误。',
	 500: '服务器发生错误，请检查服务器。',
	 502: '网关错误。',
	 503: '服务不可用，服务器暂时过载或维护。',
	 504: '网关超时。',
	 */


	private int status;
	private String describe;

	StatusEnum(int status, String describe) {
		this.status = status;
		this.describe = describe;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}