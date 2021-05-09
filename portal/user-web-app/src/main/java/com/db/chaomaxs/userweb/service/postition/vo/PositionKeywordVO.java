package com.db.chaomaxs.userweb.service.postition.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author momo
 * @date 2021-04-30 10:15
 */
@Data
public class PositionKeywordVO {

    @ApiModelProperty(name = "keywordTitle", value = "职位关键字")
    private String keywordTitle;
}
