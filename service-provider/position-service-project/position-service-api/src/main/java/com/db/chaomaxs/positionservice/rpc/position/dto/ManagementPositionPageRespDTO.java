package com.db.chaomaxs.positionservice.rpc.position.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * 系统后台企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class ManagementPositionPageRespDTO implements Serializable {

    /**
     * 系统id
     */
    @NotEmpty(message = "系统id")
    private Long id;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 职位分类id
     */
    private Long positionTypeId;


    /**
     * 省
     */
    private String provinceCode;

    /**
     * 市
     */
    private String cityCode;


    /**
     * 最低薪资
     */
    private Integer startSalary;

    /**
     * 最高薪资
     */
    private Integer endSalary;


    /**
     * 学历ID，字典表主键ID
     */
    private Long educationId;

    /**
     * 教育
     */
    private String education;


    /**
     * 经验要求：关联经验要求表主键id
     */
    private Long experienceId;

    /**
     * 经验要求
     */
    private String experience;

    /**
     * 创建人id
     */
    private Long companyUserId;

    /**
     * 创建人
     */
    private String realName;

    /**
     * 状态
     */
    private String status;


    /**
     * 公司名
     */
    private String fullName;












}
