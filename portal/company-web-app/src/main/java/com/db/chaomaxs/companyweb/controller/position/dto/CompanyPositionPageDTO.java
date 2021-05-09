package com.db.chaomaxs.companyweb.controller.position.dto;

import java.math.BigDecimal;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionPageDTO", description = "分页:企业_职位")
public class CompanyPositionPageDTO extends PageParam {

	private static final long serialVersionUID = 3153180771720249508L;
    /**
	 * 发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭
	 */
	@ApiModelProperty(name ="status", value = "发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭")
	private Integer status;

    

}
