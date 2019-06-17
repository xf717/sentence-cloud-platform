package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserInfoDTO;
import com.maruko.mall.user.server.entity.UserInfoDO;
import com.maruko.mall.user.server.mapper.IUserInfoMapper;
import com.maruko.mall.user.server.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoMapper userInfoMapper;


	@Override
	public BaseResponse add(UserInfoDTO userInfoDTO) {
            UserInfoDO userInfoDO = new UserInfoDO();
		BeanUtils.copyProperties(userInfoDTO, userInfoDO);
		int effectRow = userInfoMapper.insertSelective(userInfoDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserInfoDTO> addUserInfo(UserInfoDTO userInfoDTO){
		int effectRow = userInfoMapper.insertSelectiveUserInfo(userInfoDTO);
		ObjectRestResponse<UserInfoDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userInfoDTO);
        }
		return objectRestResponse;
    }

	@Override
	public BaseResponse update(UserInfoDTO userInfoDTO) {
            UserInfoDO userInfoDO = new UserInfoDO();
		BeanUtils.copyProperties(userInfoDTO, userInfoDO);
		int effectRow = userInfoMapper.updateByPrimaryKeySelective(userInfoDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userInfoMapper.deleteByPrimaryKey(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserInfoDTO> page(UserInfoDTO userInfoDTO, Page<UserInfoDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserInfoDTO> list = (com.github.pagehelper.Page<UserInfoDTO>) userInfoMapper.query(userInfoDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
        }
		return new TableResultResponse<DTO>();
	}

	@Override
	public ListRestResponse<UserInfoDTO> query(UserInfoDTO userInfoDTO) {
		List<UserInfoDTO> list = this.userInfoMapper.query(userInfoDTO);
		ListRestResponse<UserInfoDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserInfoDTO> findById(Integer id) {
            UserInfoDO userInfoDO = userInfoMapper.selectByPrimaryKey(id);
		ObjectRestResponse<UserInfoDTO> objectRestResponse = new ObjectRestResponse<>();
            if (userInfoDO != null) {
                    UserInfoDTO userInfoDTO = new UserInfoDTO();
				BeanUtils.copyProperties(userInfoDO, userInfoDTO);
				objectRestResponse.data(userInfoDTO);
            }
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserInfoDTO> findByCondition(UserInfoDTO userInfoDTO) {
		List<UserInfoDTO> list = userInfoMapper.query(userInfoDTO);
        ObjectRestResponse<UserInfoDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}