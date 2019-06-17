package com.maruko.mall.user.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.maruko.mall.common.enums.StatusEnum;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;
import com.maruko.mall.user.server.client.dto.UserThirdDTO;
import com.maruko.mall.user.server.entity.UserThirdDO;
import com.maruko.mall.user.server.mapper.IUserThirdMapper;
import com.maruko.mall.user.server.service.IUserThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserThirdServiceImpl implements IUserThirdService {

	@Autowired
	private IUserThirdMapper userThirdMapper;


	@Override
	public BaseResponse add(UserThirdDTO userThirdDTO) {
            UserThirdDO userThirdDO = new UserThirdDO();
		BeanUtils.copyProperties(userThirdDTO, userThirdDO);
		int effectRow = userThirdMapper.insertSelective(userThirdDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public ObjectRestResponse<UserThirdDTO> addUserThird(UserThirdDTO userThirdDTO){
		int effectRow = userThirdMapper.insertSelectiveUserThird(userThirdDTO);
		ObjectRestResponse<UserThirdDTO> objectRestResponse = new ObjectRestResponse<>();
		if (effectRow > 0) {
			objectRestResponse.data(userThirdDTO);
        }
		return objectRestResponse;
    }

	@Override
	public BaseResponse update(UserThirdDTO userThirdDTO) {
            UserThirdDO userThirdDO = new UserThirdDO();
		BeanUtils.copyProperties(userThirdDTO, userThirdDO);
		int effectRow = userThirdMapper.updateByPrimaryKeySelective(userThirdDO);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public BaseResponse remove(Integer id) {
		Integer effectRow = userThirdMapper.deleteByPrimaryKey(id);
		if (effectRow > 0) {
			return BaseResponse.success(StatusEnum.SUCCESS.getDescribe());
		}
		return BaseResponse.failure(StatusEnum.FAILURE.getDescribe());
	}

	@Override
	public TableResultResponse<UserThirdDTO> page(UserThirdDTO userThirdDTO, Page<UserThirdDTO> page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		com.github.pagehelper.Page<UserThirdDTO> list = (com.github.pagehelper.Page<UserThirdDTO>) userThirdMapper.query(userThirdDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return new TableResultResponse(list.getTotal(), list.getPages(), list.getResult());
        }
		return new TableResultResponse<DTO>();
	}

	@Override
	public ListRestResponse<UserThirdDTO> query(UserThirdDTO userThirdDTO) {
		List<UserThirdDTO> list = this.userThirdMapper.query(userThirdDTO);
		ListRestResponse<UserThirdDTO> listRestResponse = new ListRestResponse<>();
		listRestResponse.count(list.size());
		listRestResponse.result(list);
		return listRestResponse;
	}

	@Override
	public ObjectRestResponse<UserThirdDTO> findById(Integer id) {
            UserThirdDO userThirdDO = userThirdMapper.selectByPrimaryKey(id);
		ObjectRestResponse<UserThirdDTO> objectRestResponse = new ObjectRestResponse<>();
            if (userThirdDO != null) {
                    UserThirdDTO userThirdDTO = new UserThirdDTO();
				BeanUtils.copyProperties(userThirdDO, userThirdDTO);
				objectRestResponse.data(userThirdDTO);
            }
		return objectRestResponse;
	}

	@Override
	public ObjectRestResponse<UserThirdDTO> findByCondition(UserThirdDTO userThirdDTO) {
		List<UserThirdDTO> list = userThirdMapper.query(userThirdDTO);
        ObjectRestResponse<UserThirdDTO> objectRestResponse = new ObjectRestResponse<>();
		if (!CollectionUtils.isEmpty(list)) {
			objectRestResponse.data(list.get(0));
		}
		return objectRestResponse;
	}
}