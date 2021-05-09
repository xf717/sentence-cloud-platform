package com.db.chaomaxs.positionservice.dal.mysql.dataobject.position;

import lombok.Data;
import java.math.BigDecimal;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
public class GetCompanyPositionDO {
    /**
     * 系统id
     */
    private Long id;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 企业用户ID
     */
    private Long companyUserId;

    /**
     * 职位类别id,关联职位分类表id
     */
    private Long positionTypeId;

    /**
     * 经验要求：关联经验要求表主键id
     */
    private Long experienceId;

    /**
     * 学历ID，字典表主键ID
     */
    private Long educationId;


    /**
     * 最低薪资
     */
    private Integer startSalary;

    /**
     * 最高薪资
     */
    private Integer endSalary;

    /**
     * 年终奖
     */
    private Integer yearSalary;

    /**
     * 省份
     */
    private String provinceCode;

    /**
     * 城市
     */
    private String cityCode;

    /**
     * 区
     */
    private String areaCode;


    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 职位内容
     */
    private String content;


}
