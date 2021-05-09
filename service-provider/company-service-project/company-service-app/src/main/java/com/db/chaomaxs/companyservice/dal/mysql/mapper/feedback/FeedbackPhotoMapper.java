package com.db.chaomaxs.companyservice.dal.mysql.mapper.feedback;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackPhotoDO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface FeedbackPhotoMapper extends BaseMapper<FeedbackPhotoDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<FeedbackPhotoDO> selectList(FeedbackPhotoListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<FeedbackPhotoDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<FeedbackPhotoDO> selectPage(FeedbackPhotoPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<FeedbackPhotoDO>());
  }

}
