package com.db.chaomaxs.positionservice.rpc.position.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 *
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class ManagementPositionPageReqDTO extends PageParam implements Serializable {

    /**
     * 企业用户ID
     */
    private Long companyUserId;
}
