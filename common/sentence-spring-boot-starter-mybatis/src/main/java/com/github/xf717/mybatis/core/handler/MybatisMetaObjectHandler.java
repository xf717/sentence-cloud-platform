package com.github.xf717.mybatis.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.mybatis.core.constant.FieldFillConstant;
import java.util.Date;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * MybatisMetaObjectHandler
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2020/06/03 21:13
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void insertFill(MetaObject metaObject) {
    logger.info("start insert fill ....");
    this.strictInsertFill(metaObject, FieldFillConstant.CREATE_TIME, Date.class,
        new Date());
    this.strictInsertFill(metaObject, FieldFillConstant.UPDATE_TIME, Date.class,
        new Date());

    final String userId = BaseContextHandler.getUserID();
    logger.info("insert fill createBy....{}", userId);
    Long createBy = 0L;
    if (StringUtils.hasText(userId)) {
      createBy = Long.parseLong(userId);
    }
    this.strictInsertFill(metaObject, FieldFillConstant.CREATE_BY, Long.class, createBy);

    logger.info("insert fill updateBy....{}", userId);
    this.strictInsertFill(metaObject, FieldFillConstant.UPDATE_BY, Long.class,
        createBy);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    logger.info("start update fill ....");

    final String userId = BaseContextHandler.getUserID();
    logger.info("update fill createBy....{}", userId);

    this.strictInsertFill(metaObject, FieldFillConstant.UPDATE_BY, Long.class,
        StringUtils.hasText(userId) ? Long.parseLong(userId) : 0L);

    this.strictUpdateFill(metaObject, FieldFillConstant.UPDATE_TIME, Date.class,
        new Date());
  }
}
