package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserTypeDTO;
import com.maruko.mall.user.server.entity.UserTypeDO;
import com.maruko.mall.user.server.mapper.IUserTypeMapper;
import com.maruko.mall.user.server.service.IUserTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserTypeServiceImpl implements IUserTypeService {

	@Autowired
	private IUserTypeMapper userTypeMapper;


	@Override
	public BaseResponse add(UserTypeDTO userTypeDTO) {
            UserTypeDO userTypeDO = new UserTypeDO();
		BeanUtils.copyProperties(userTypeDTO, userTypeDO);
		int effectRow = userTypeMapper.insertSelective(userTypeDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserTypeDTO> addUserType(UserTypeDTO userTypeDTO){
		int effectRow = userTypeMapper.insertSelectiveUserType(userTypeDTO);
		ObjectRestResponse<UserTypeDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userTypeDTO);
        }
		return objectRestResponse;
    }

	@Override
	public BaseResponse update(UserTypeDTO userTypeDTO) {
            UserTypeDO userTypeDO = new UserTypeDO();
		BeanUtils.copyProperties(userTypeDTO, userTypeDO);
		int effectRow = userTypeMapper.updateByPrimaryKeySelective(userTypeDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userTypeMapper.deleteByPrimaryKey(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserTypeDTO> page(UserTypeDTO userTypeDTO, Page<UserTypeDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserTypeDTO> list = (com.github.pagehelper.Page<UserTypeDTO>) userTypeMapper.query(userTypeDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
        }
		return new TableResultResponse<DTO>();
	}

	@Override
	public ListRestResponse<UserTypeDTO> query(UserTypeDTO userTypeDTO) {
		List<UserTypeDTO> list = this.userTypeMapper.query(userTypeDTO);
		ListRestResponse<UserTypeDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserTypeDTO> findById(Integer id) {
            UserTypeDO userTypeDO = userTypeMapper.selectByPrimaryKey(id);
		ObjectRestResponse<UserTypeDTO> objectRestResponse = new ObjectRestResponse<>();
            if (userTypeDO != null) {
                    UserTypeDTO userTypeDTO = new UserTypeDTO();
				BeanUtils.copyProperties(userTypeDO, userTypeDTO);
				objectRestResponse.data(userTypeDTO);
            }
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserTypeDTO> findByCondition(UserTypeDTO userTypeDTO) {
		List<UserTypeDTO> list = userTypeMapper.query(userTypeDTO);
        ObjectRestResponse<UserTypeDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}