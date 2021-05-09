package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


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
public class CompanyPositionKeywordRespDTO implements Serializable {

    /**
     * 职位关键字id
     */
    private Long positionKeywordId;

    /**
     * 职位关键字名称
     */
    private String keywordTitle;


}
