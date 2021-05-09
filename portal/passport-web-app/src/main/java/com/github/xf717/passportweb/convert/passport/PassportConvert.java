package com.github.xf717.passportweb.convert.passport;

import com.github.xf717.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginByThirdPartyReqDTO;
import com.github.xf717.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 登录通行相关数据转换
 *
 * @author xiaofeng
 */
@Mapper
public interface PassportConvert {

  PassportConvert INSTANCE = Mappers.getMapper(PassportConvert.class);

  /**
   * 登录转参数转换
   *
   * @param passportLoginBySmsReqDTO
   * @return
   */
  UserVerifySmsCodeReqDTO convert(PassportLoginBySmsReqDTO passportLoginBySmsReqDTO);

  /**
   * 第三方登录 小程序获取用户信息进行转换
   *
   * @param thirdPartyReqDTO
   * @return
   */
  @Mappings({
      @Mapping(source = "nickName", target = "nickname"),
      @Mapping(source = "sex", target = "gender"),
      @Mapping(source = "openId", target = "thirdIden")
  })
  UserInfoCreateReqDTO convert(PassportLoginByThirdPartyReqDTO thirdPartyReqDTO);


  /**
   * 微信登录
   *
   * @param wxMpUser
   * @return
   */
  @Mappings({
      @Mapping(source = "openId", target = "thirdIden"),
      @Mapping(source = "sex", target = "gender"),
      @Mapping(source = "headImgUrl", target = "avatarUrl")
  })
  UserInfoCreateReqDTO convert(WxMpUser wxMpUser);

}
