package com.db.chaomaxs.positionservice.rpc.position.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionDetailRespDTO implements Serializable {



    /**
     * 系统id
     */
    private Long id;

    /**
     * 职位名称
     */
    private String positionName;



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
     * 职位描述
     */
    private String content;

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
     * 详细地址(街道)
     */
    private String street;


    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 商圈
     */
    private String businessDistrict;

    /**
     * 发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭
     */
    private String status;

    /**
     * 职位关键字
     */
    private List<CompanyPositionKeywordRespDTO> keywordList;

    /**
     * 企业用户id
     */
    private Long companyUserId;


}
