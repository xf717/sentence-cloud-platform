package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserExtendDTO;
import com.maruko.mall.user.server.entity.UserExtendDO;
import com.maruko.mall.user.server.mapper.UserExtendMapper;
import com.maruko.mall.user.server.service.IUserExtendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserExtendServiceImpl implements IUserExtendService {

	@Autowired
	private UserExtendMapper userExtendMapper;


	@Override
	public BaseResponse add(UserExtendDTO userExtendDTO) {
		UserExtendDO userExtendDO = new UserExtendDO();
		BeanUtils.copyProperties(userExtendDTO, userExtendDO);
		int effectRow = userExtendMapper.insert(userExtendDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserExtendDTO> addUserExtend(UserExtendDTO userExtendDTO) {
		int effectRow = userExtendMapper.insertSelectiveUserExtend(userExtendDTO);
		ObjectRestResponse<UserExtendDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userExtendDTO);
		}
		return objectRestResponse;
	}

	@Override
	public BaseResponse update(UserExtendDTO userExtendDTO) {
		UserExtendDO userExtendDO = new UserExtendDO();
		BeanUtils.copyProperties(userExtendDTO, userExtendDO);
		int effectRow = userExtendMapper.updateById(userExtendDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userExtendMapper.deleteById(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserExtendDTO> page(UserExtendDTO userExtendDTO, Page<UserExtendDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserExtendDTO> list = (com.github.pagehelper.Page<UserExtendDTO>) userExtendMapper
				.query(userExtendDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
		}
		return new TableResultResponse<>();
	}

	@Override
	public ListRestResponse<UserExtendDTO> query(UserExtendDTO userExtendDTO) {
		List<UserExtendDTO> list = this.userExtendMapper.query(userExtendDTO);
		ListRestResponse<UserExtendDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserExtendDTO> findById(Integer id) {
		UserExtendDO userExtendDO = userExtendMapper.selectById(id);
		ObjectRestResponse<UserExtendDTO> objectRestResponse = new ObjectRestResponse<>();
		if (userExtendDO != null) {
			UserExtendDTO userExtendDTO = new UserExtendDTO();
			BeanUtils.copyProperties(userExtendDO, userExtendDTO);
			objectRestResponse.data(userExtendDTO);
		}
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserExtendDTO> findByCondition(UserExtendDTO userExtendDTO) {
		List<UserExtendDTO> list = userExtendMapper.query(userExtendDTO);
		ObjectRestResponse<UserExtendDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}