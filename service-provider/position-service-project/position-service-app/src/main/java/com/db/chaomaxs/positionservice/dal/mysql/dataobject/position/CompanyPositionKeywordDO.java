package com.db.chaomaxs.positionservice.dal.mysql.dataobject.position;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 职位_关键词_管理
 *
 * @author momo
 * @date 2021-04-20 11:16:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_position_keyword")
public class CompanyPositionKeywordDO extends DeletableDO {

    /**
     * 系统id
     */
    private Long id;

    /**
     * 职位管理id
     */
    private Long companyPositionId;

    /**
     * 职位关键字id
     */
    private Long positionKeywordId;
}
