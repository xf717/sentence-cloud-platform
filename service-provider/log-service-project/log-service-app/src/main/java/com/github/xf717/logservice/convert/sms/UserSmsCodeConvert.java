package com.github.xf717.logservice.convert.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeSaveMessage;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeUpdateMessage;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserSmsCodeConvert
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Mapper
public interface UserSmsCodeConvert {

  UserSmsCodeConvert INSTANCE = Mappers.getMapper(UserSmsCodeConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserSmsCodeDO convert(UserSmsCodeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserSmsCodeDO convert(UserSmsCodeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserSmsCodeRespDTO> convertList(List<UserSmsCodeDO> list);

  /**
   * 对象转换
   *
   * @param userSmsCodeDO
   * @return
   */
  UserSmsCodeRespDTO convert(UserSmsCodeDO userSmsCodeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserSmsCodeRespDTO> convertPage(IPage<UserSmsCodeDO> page);

  /**
   * 将MQ 生成对象数据转换对象要存储的对象
   *
   * @param message
   * @return
   */
  UserSmsCodeDO convert(UserSmsCodeSaveMessage message);

  /**
   * 将MQ 生成对象数据转换成要更新的对象
   *
   * @param message
   * @return
   */
  UserSmsCodeDO convert(UserSmsCodeUpdateMessage message);


}
