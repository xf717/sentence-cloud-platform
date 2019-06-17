package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserIntegralDTO;
import com.maruko.mall.user.server.entity.UserIntegralDO;
import com.maruko.mall.user.server.mapper.IUserIntegralMapper;
import com.maruko.mall.user.server.service.IUserIntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserIntegralServiceImpl implements IUserIntegralService {

	@Autowired
	private IUserIntegralMapper userIntegralMapper;


	@Override
	public BaseResponse add(UserIntegralDTO userIntegralDTO) {
            UserIntegralDO userIntegralDO = new UserIntegralDO();
		BeanUtils.copyProperties(userIntegralDTO, userIntegralDO);
		int effectRow = userIntegralMapper.insertSelective(userIntegralDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserIntegralDTO> addUserIntegral(UserIntegralDTO userIntegralDTO){
		int effectRow = userIntegralMapper.insertSelectiveUserIntegral(userIntegralDTO);
		ObjectRestResponse<UserIntegralDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userIntegralDTO);
        }
		return objectRestResponse;
    }

	@Override
	public BaseResponse update(UserIntegralDTO userIntegralDTO) {
            UserIntegralDO userIntegralDO = new UserIntegralDO();
		BeanUtils.copyProperties(userIntegralDTO, userIntegralDO);
		int effectRow = userIntegralMapper.updateByPrimaryKeySelective(userIntegralDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userIntegralMapper.deleteByPrimaryKey(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserIntegralDTO> page(UserIntegralDTO userIntegralDTO, Page<UserIntegralDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserIntegralDTO> list = (com.github.pagehelper.Page<UserIntegralDTO>) userIntegralMapper.query(userIntegralDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
        }
		return new TableResultResponse<DTO>();
	}

	@Override
	public ListRestResponse<UserIntegralDTO> query(UserIntegralDTO userIntegralDTO) {
		List<UserIntegralDTO> list = this.userIntegralMapper.query(userIntegralDTO);
		ListRestResponse<UserIntegralDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserIntegralDTO> findById(Integer id) {
            UserIntegralDO userIntegralDO = userIntegralMapper.selectByPrimaryKey(id);
		ObjectRestResponse<UserIntegralDTO> objectRestResponse = new ObjectRestResponse<>();
            if (userIntegralDO != null) {
                    UserIntegralDTO userIntegralDTO = new UserIntegralDTO();
				BeanUtils.copyProperties(userIntegralDO, userIntegralDTO);
				objectRestResponse.data(userIntegralDTO);
            }
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserIntegralDTO> findByCondition(UserIntegralDTO userIntegralDTO) {
		List<UserIntegralDTO> list = userIntegralMapper.query(userIntegralDTO);
        ObjectRestResponse<UserIntegralDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}