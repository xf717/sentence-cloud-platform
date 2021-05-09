package com.github.xf717.userweb.controller.user.dto;

import com.github.xf717.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 就可以去掉 企业_用户_收藏
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "CompanyUserCollectPageDTO", description = "分页:企业_用户_收藏")
public class CompanyUserCollectPageDTO extends PageParam {

  private static final long serialVersionUID = 4507853962818897764L;
}
