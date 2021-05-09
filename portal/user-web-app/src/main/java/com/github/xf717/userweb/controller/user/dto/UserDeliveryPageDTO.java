package com.github.xf717.userweb.controller.user.dto;

import com.github.xf717.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 企业投递表
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserDeliveryPageDTO",description = "分页:企业投递表")
public class UserDeliveryPageDTO extends PageParam {

  private static final long serialVersionUID = 1L;
}
