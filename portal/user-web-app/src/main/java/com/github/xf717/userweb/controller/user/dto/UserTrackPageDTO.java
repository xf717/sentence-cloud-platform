package com.github.xf717.userweb.controller.user.dto;

import com.github.xf717.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 *
 * @author momo
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserPositionCollectPageDTO", description = "分页:用户_职位_收藏")
public class UserTrackPageDTO extends PageParam {

    private static final long serialVersionUID = 1L;


}
