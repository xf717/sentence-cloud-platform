package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserExpectedPositionIndustryDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Repository
public interface UserExpectedPositionIndustryMapper extends
    CommonMapper<UserExpectedPositionIndustryDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserExpectedPositionIndustryDO> selectList(
      UserExpectedPositionIndustryListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserExpectedPositionIndustryDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserExpectedPositionIndustryDO> selectPage(
      UserExpectedPositionIndustryPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserExpectedPositionIndustryDO>());
  }

  /**
   * 根据求职期望id 删除期望行业数据
   * @param expectedPositionId
   */
  void deleteByExpectedPositionId(@Param("expectedPositionId")Long expectedPositionId);

  /**
   * 批量插入
   * @param industryList
   */
  int batchInsert(@Param("industryList")List<UserExpectedPositionIndustryDO> industryList);

  /**
   * 根据求职期望id查询
   * @param expectedPositionId
   * @return
   */
  List<UserExpectedPositionIndustryDO> listIndustryByExpectedPositionId(@Param("expectedPositionId") Long expectedPositionId);
}
