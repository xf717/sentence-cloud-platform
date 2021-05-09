package com.github.xf717.logservice.dal.mysql.mapper.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Repository
public interface UserSmsCodeMapper extends BaseMapper<UserSmsCodeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserSmsCodeDO> selectList(UserSmsCodeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserSmsCodeDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserSmsCodeDO> selectPage(UserSmsCodePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserSmsCodeDO>());
  }

  /**
   * 获得手机号的最后一个手机验证码
   *
   * @param mobile
   * @param scene
   * @return
   */
  default UserSmsCodeDO selectLastByMobile(String mobile, Integer scene) {
    // rpc 调用参数不能为空,所以设置了默认值 -1
    if (scene.equals(-1)) {
      scene = null;
    }
    QueryWrapper<UserSmsCodeDO> query = new QueryWrapperX<UserSmsCodeDO>().eq("mobile", mobile)
        .eqIfPresent("scene", scene)
        .orderByDesc("id")
        .last("limit 1")
        //指定返回的列属性
        .select("id", "mobile", "code", "scene", "today_index", "is_used as used", "used_time",
            "create_time");
    return selectOne(query);
  }

}
