package com.db.chaomaxs.positionservice.rpc.positiontype.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.PositionTypeRpcImpl;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionTypeApi;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@RestController
public class PositionTypeRpcController implements PositionTypeApi {

	@Autowired
	private PositionTypeRpcImpl positionTypeRpc;

	@Override
	public BaseResponse save(@RequestBody PositionTypeCreateReqDTO createReqDTO) {
		return positionTypeRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody PositionTypeUpdateReqDTO updateReqDTO) {
		return positionTypeRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return positionTypeRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<PositionTypeRespDTO> getPositionTypeById(@PathVariable("id") Long id) {
		return positionTypeRpc.getPositionTypeById(id);
	}

	@Override
	public ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypes(@RequestBody PositionTypeListQueryReqDTO listQuery) {
		return positionTypeRpc.listPositionTypes(listQuery);
	}

	@Override
	public TableResultResponse<PositionTypeRespDTO> page(@RequestBody PositionTypePageReqDTO pageReqDTO) {
		return positionTypeRpc.page(pageReqDTO);
	}

	/**
	 * 根据参数查询所有可显示分类
	 * @param listQuery  查询参数
	 * @return
	 */
	@Override
	public ObjectRestResponse<List<PositionTypeRespDTO>> listDisplayPositionType(
			PositionTypeListQueryReqDTO listQuery) {
		return positionTypeRpc.listDisplayPositionType(listQuery);
	}


	/**
	 * 根据parentId查询数据,不分页
	 * @param parentId  查询参数
	 * @return
	 */
	@Override
	public ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypeByParentId(Long parentId) {
		return positionTypeRpc.listPositionTypeByParentId(parentId);
	}


}
