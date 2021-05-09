package com.db.chaomaxs.positionservice.dal.mysql.dataobject.position;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 职位_关键词_管理
 *
 * @author momo
 * @date 2021-04-20 11:16:23
 */
@Data
@Accessors(chain = true)
public class GetCompanyPositionKeywordDO {
    /**
     * 职位管理id
     */
    private Long companyPositionId;

    /**
     * 职位关键字id
     */
    private Long positionKeywordId;

    private String keywordTitle;


}
