package com.db.chaomaxs.companyservice.rpc.interview.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author momo
 * @date 2021-04-12 19:56
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewUsersRespDTO {
    /**
     * 企业用户id
     */
    private Long id;

    /**
     * 企业用户id
     */
    private Long userId;
}
