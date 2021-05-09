package com.db.chaomaxs.companyweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionBasePageVO", description = "企业_职位")
public class CompanyPositionBasePageVO extends AbstractPositionPageVO {
}
