package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionKeywordCreateReqDTO implements Serializable {


    /**
     * 职位关键字id
     */
    private Long positionKeywordId;


}
