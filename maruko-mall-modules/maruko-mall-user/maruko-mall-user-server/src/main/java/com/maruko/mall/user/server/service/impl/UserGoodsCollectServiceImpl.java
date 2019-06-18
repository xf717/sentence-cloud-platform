package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserGoodsCollectDTO;
import com.maruko.mall.user.server.entity.UserGoodsCollectDO;
import com.maruko.mall.user.server.mapper.UserGoodsCollectMapper;
import com.maruko.mall.user.server.service.IUserGoodsCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserGoodsCollectServiceImpl implements IUserGoodsCollectService {

	@Autowired
	private UserGoodsCollectMapper userGoodsCollectMapper;


	@Override
	public BaseResponse add(UserGoodsCollectDTO userGoodsCollectDTO) {
		UserGoodsCollectDO userGoodsCollectDO = new UserGoodsCollectDO();
		BeanUtils.copyProperties(userGoodsCollectDTO, userGoodsCollectDO);
		int effectRow = userGoodsCollectMapper.insert(userGoodsCollectDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserGoodsCollectDTO> addUserGoodsCollect(UserGoodsCollectDTO userGoodsCollectDTO) {
		int effectRow = userGoodsCollectMapper.insertSelectiveUserGoodsCollect(userGoodsCollectDTO);
		ObjectRestResponse<UserGoodsCollectDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userGoodsCollectDTO);
		}
		return objectRestResponse;
	}

	@Override
	public BaseResponse update(UserGoodsCollectDTO userGoodsCollectDTO) {
		UserGoodsCollectDO userGoodsCollectDO = new UserGoodsCollectDO();
		BeanUtils.copyProperties(userGoodsCollectDTO, userGoodsCollectDO);
		int effectRow = userGoodsCollectMapper.updateById(userGoodsCollectDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userGoodsCollectMapper.deleteById(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserGoodsCollectDTO> page(UserGoodsCollectDTO userGoodsCollectDTO,
			Page<UserGoodsCollectDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserGoodsCollectDTO> list = (com.github.pagehelper.Page<UserGoodsCollectDTO>) userGoodsCollectMapper
				.query(userGoodsCollectDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
		}
		return new TableResultResponse<>();
	}

	@Override
	public ListRestResponse<UserGoodsCollectDTO> query(UserGoodsCollectDTO userGoodsCollectDTO) {
		List<UserGoodsCollectDTO> list = this.userGoodsCollectMapper.query(userGoodsCollectDTO);
		ListRestResponse<UserGoodsCollectDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserGoodsCollectDTO> findById(Integer id) {
		UserGoodsCollectDO userGoodsCollectDO = userGoodsCollectMapper.selectById(id);
		ObjectRestResponse<UserGoodsCollectDTO> objectRestResponse = new ObjectRestResponse<>();
		if (userGoodsCollectDO != null) {
			UserGoodsCollectDTO userGoodsCollectDTO = new UserGoodsCollectDTO();
			BeanUtils.copyProperties(userGoodsCollectDO, userGoodsCollectDTO);
			objectRestResponse.data(userGoodsCollectDTO);
		}
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserGoodsCollectDTO> findByCondition(UserGoodsCollectDTO userGoodsCollectDTO) {
		List<UserGoodsCollectDTO> list = userGoodsCollectMapper.query(userGoodsCollectDTO);
		ObjectRestResponse<UserGoodsCollectDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}