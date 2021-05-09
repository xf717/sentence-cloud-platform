package com.db.chaomaxs.positionservice.rpc.position.dto;

import lombok.Data;
import javax.validation.constraints.Size;

/**
 * @author momo
 * @date 2021-04-21 10:48
 */
@Data
public class CompanyPositionAuditReqDTO {

    private Long id;

    private Integer status;

    private String reason;

    private Long auditUserId;
}
