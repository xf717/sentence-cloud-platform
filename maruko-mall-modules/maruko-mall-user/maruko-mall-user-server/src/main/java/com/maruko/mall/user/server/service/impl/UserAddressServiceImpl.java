package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserAddressDTO;
import com.maruko.mall.user.server.entity.UserAddressDO;
import com.maruko.mall.user.server.mapper.UserAddressMapper;
import com.maruko.mall.user.server.service.IUserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private UserAddressMapper userAddressMapper;


	@Override
	public BaseResponse add(UserAddressDTO userAddressDTO) {
            UserAddressDO userAddressDO = new UserAddressDO();
		BeanUtils.copyProperties(userAddressDTO, userAddressDO);
		int effectRow = userAddressMapper.insert(userAddressDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserAddressDTO> addUserAddress(UserAddressDTO userAddressDTO){
		int effectRow = userAddressMapper.insertSelectiveUserAddress(userAddressDTO);
		ObjectRestResponse<UserAddressDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userAddressDTO);
        }
		return objectRestResponse;
    }

	@Override
	public BaseResponse update(UserAddressDTO userAddressDTO) {
            UserAddressDO userAddressDO = new UserAddressDO();
		BeanUtils.copyProperties(userAddressDTO, userAddressDO);
		int effectRow = userAddressMapper.updateById(userAddressDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userAddressMapper.deleteById(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserAddressDTO> page(UserAddressDTO userAddressDTO, Page<UserAddressDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserAddressDTO> list = (com.github.pagehelper.Page<UserAddressDTO>) userAddressMapper.query(userAddressDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
        }
		return new TableResultResponse<>();
	}

	@Override
	public ListRestResponse<UserAddressDTO> query(UserAddressDTO userAddressDTO) {
		List<UserAddressDTO> list = this.userAddressMapper.query(userAddressDTO);
		ListRestResponse<UserAddressDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserAddressDTO> findById(Integer id) {
            UserAddressDO userAddressDO = userAddressMapper.selectById(id);
		ObjectRestResponse<UserAddressDTO> objectRestResponse = new ObjectRestResponse<>();
            if (userAddressDO != null) {
                    UserAddressDTO userAddressDTO = new UserAddressDTO();
				BeanUtils.copyProperties(userAddressDO, userAddressDTO);
				objectRestResponse.data(userAddressDTO);
            }
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserAddressDTO> findByCondition(UserAddressDTO userAddressDTO) {
		List<UserAddressDTO> list = userAddressMapper.query(userAddressDTO);
        ObjectRestResponse<UserAddressDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}