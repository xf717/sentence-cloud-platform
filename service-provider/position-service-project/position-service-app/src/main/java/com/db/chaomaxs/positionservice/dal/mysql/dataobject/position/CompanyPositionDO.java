package com.db.chaomaxs.positionservice.dal.mysql.dataobject.position;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_position")
public class CompanyPositionDO extends DeletableDO {

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
     * 经验要求：冗余字段
     */
    private String experience;

    /**
     * 学历ID，字典表主键ID
     */
    private Long educationId;

    /**
     * 学历
     */
    private String education;

    /**
     * 最低薪资
     */
    private Integer startSalary;

    /**
     * 最高薪资
     */
    private Integer endSalary;

    /**
     * 最高薪资
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
     * 详细地址(街道)
     */
    private String street;

    /**
     * 详细地址(完整地址)
     */
    private String address;

    /**
     * 地图上地址
     */
    private String mapAddress;

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
    private Integer status;


}
