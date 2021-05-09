package com.github.xf717.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
public class UserTrackStatisticRespDTO implements Serializable {

    private Long positionId;

    private Integer count;
}
