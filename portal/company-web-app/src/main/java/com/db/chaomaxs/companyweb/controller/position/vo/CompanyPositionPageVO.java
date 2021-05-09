package com.db.chaomaxs.companyweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionVO", description = "企业_职位")
public class CompanyPositionPageVO extends AbstractPositionPageVO {
    /**
     * 学历
     */
    @ApiModelProperty(name = "tractCount", value = "多少人查看")
    private Integer tractCount;

    /**
     * 最低薪资
     */
    @ApiModelProperty(name = "chatCount", value = "多少人沟通")
    private Integer chatCount;
}
