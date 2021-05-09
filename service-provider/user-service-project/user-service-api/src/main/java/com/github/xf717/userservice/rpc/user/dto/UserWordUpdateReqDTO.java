package com.github.xf717.userservice.rpc.user.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserWordUpdateReqDTO implements Serializable {
    /**
     *
     */
    @NotEmpty(message = "")
    private Long id;

    /**
     * 内容
     */
    private String content;


    /**
     * 修改人
     */
    private Long updateBy;


}
