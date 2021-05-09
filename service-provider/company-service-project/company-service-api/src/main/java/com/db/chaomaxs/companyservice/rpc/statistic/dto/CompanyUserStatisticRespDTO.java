package com.db.chaomaxs.companyservice.rpc.statistic.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
public class CompanyUserStatisticRespDTO implements Serializable {


    private Integer chatCount = 0;

    private Integer collectCount = 0;

    private Integer deliveryCount = 0;

    private Integer interviewCount = 0;


}
