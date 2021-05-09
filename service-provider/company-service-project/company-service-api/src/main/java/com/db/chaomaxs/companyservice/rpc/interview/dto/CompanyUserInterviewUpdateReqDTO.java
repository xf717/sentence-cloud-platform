package com.db.chaomaxs.companyservice.rpc.interview.dto;
import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewUpdateReqDTO implements Serializable {


    /**
     * 主键id
     */
    @NotEmpty(message = "主键id")
    private Long id;

    /**
     * 企业用户id
     */
    private Long companyUserId;

    /**
     * 企业用户id
     */
    private Long companyId;

    /**
     * 职位id
     */
    private Long positionId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 地址
     */
    private String interviewAddress;

    /**
     * 面试时间
     */
    private Date interviemTime;

    /**
     * 职位名
     */
    private String positionName;

    /**
     * 手机号
     */
    private String mobile;

}
