package com.maruko.mall.convert;

import com.maruko.mall.common.util.DateUtil;
import com.maruko.mall.user.server.client.bo.User;
import com.maruko.mall.user.server.client.bo.UserAddressBO;
import com.maruko.mall.user.server.client.bo.UserInfoBO;
import com.maruko.mall.user.server.client.bo.UserTypeBO;
import com.maruko.mall.user.server.convert.UserAddressConvert;
import com.maruko.mall.user.server.convert.UserConvert;
import com.maruko.mall.user.server.convert.UserInfoConvert;
import com.maruko.mall.user.server.convert.UserTypeConvert;
import com.maruko.mall.user.server.entity.UserAddressDO;
import com.maruko.mall.user.server.entity.UserDO;
import com.maruko.mall.user.server.entity.UserInfoDO;
import com.maruko.mall.user.server.entity.UserTypeDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

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
		System.out.println("userInfoBO==" + userInfoBO);
		Assert.assertTrue(userInfoBO.getUserId().equals(userInfoDO.getUserId()));
 		Assert.assertTrue(userInfoBO.getMobile().equals(userInfoDO.getMobile()));
	}

	@Test
	public void testUserTypeConvert(){
		UserTypeDO userTypeDO = new UserTypeDO()
				.setUserTypeId(1)
				.setUserTypeName("QQ")
				.setCreateBy(1)
				.setCreateTime(DateUtil.getCurrentTime())
				.setModifyBy(1)
				.setModifyTime(DateUtil.getCurrentTime());

		UserTypeBO userTypeBO = new UserTypeBO();
		BeanUtils.copyProperties(userTypeDO,userTypeBO);

		System.out.println("userTypeBO==" + userTypeBO);
	}

	@Test
	public void testUserConvert(){
		UserDO userDO = new UserDO().setName("xin");
		User user = UserConvert.INSTANCE.convert(userDO);
		System.out.println(user);
	}



	@Test
	public void testUserAddressConvert(){
		UserAddressDO userAddressDO = new UserAddressDO()
				.setAddress("福建省泉州市惠安县东岭镇")
				.setAddressId(1)
				.setUserId(2)
				.setAlias("额额")
				.setCityId(1)
				.setContact("老纳法号叫乱来")
				.setCountyId(2);
		long startTime = System.currentTimeMillis();
		UserAddressBO userAddressBO = UserAddressConvert.INSTANCE.convert(userAddressDO);
		long endTime = System.currentTimeMillis();
		System.out.println("总耗时==" + (endTime - startTime));
		System.out.println(userAddressBO);

	}


}
