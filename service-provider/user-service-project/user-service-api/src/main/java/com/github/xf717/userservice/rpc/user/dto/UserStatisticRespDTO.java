package com.github.xf717.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 *
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
public class UserStatisticRespDTO implements Serializable {

    private Integer deliveryCount;

    private Integer interviewCount;

    private Integer collectCount;

    private Integer trackCount;


}
