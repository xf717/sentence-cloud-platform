package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionRespDTO implements Serializable {

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


    private String status;

    /**
     * 区
     */
    private String areaCode;

    /**
     * 商圈
     */
    private String businessDistrict;

    /**
     * 职位关键字
     */
    private List<CompanyPositionKeywordRespDTO> keywordList;


}
