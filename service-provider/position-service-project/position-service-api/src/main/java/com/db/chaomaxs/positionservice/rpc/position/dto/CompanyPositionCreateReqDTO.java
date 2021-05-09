package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-20 09:45:08
 */
@Data
@Accessors(chain = true)
public class CompanyPositionCreateReqDTO implements Serializable {


    /**
     *职位名称
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
     * 详细地址(完整地址)
     */
    private String address;

    /**
     * 异常订单状态,0:正常、1:异常订单
     */
    private String mapAddress;

    /**
     * 渠道id
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
     * 关键字
     */
    private Set<Long> KeywordIds;


}
