package com.maruko.mall.convert;

import com.maruko.mall.common.util.DateUtil;
import com.maruko.mall.user.server.client.bo.UserInfoBO;
import com.maruko.mall.user.server.convert.UserInfoConvert;
import com.maruko.mall.user.server.entity.UserInfoDO;
import org.junit.Assert;
import org.junit.Test;

/**
 * UserInfoConvertTest
 * @author xiaofeng
 * @date 2019/06/18 15:00
 * @version 1.0
 */
public class UserInfoConvertTest {

	@Test
	public void testUserInfoConvert(){
		UserInfoDO userInfoDO = new UserInfoDO()
				.setUserId(1)
				.setMobile("13820895211")
				.setUserPwd("111")
				.setUserStatus(1)
				.setCreateBy(1)
				.setCreateTime(DateUtil.getCurrentTime())
				.setModifyBy(1)
				.setModifyTime(DateUtil.getCurrentTime())
				.setNickname("老纳法号叫乱来")
				.setPhoto("image/photo.jpg")
				.setSalt("123456");
		UserInfoBO userInfoBO = UserInfoConvert.INSTANCE.convert(userInfoDO);
		Assert.assertTrue(userInfoBO.getUserId().equals(userInfoDO.getUserId()));
 		Assert.assertTrue(userInfoBO.getMobile().equals(userInfoDO.getMobile()));
		System.out.println("userInfoBO==" + userInfoBO);

	}
}
