package com.db.chaomaxs.positionservice.rpc.position.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author momo
 * @date 2021-04-20 09:36
 */

@Data
public class IdsReqDTO {
    private Set<Long> ids;
}
