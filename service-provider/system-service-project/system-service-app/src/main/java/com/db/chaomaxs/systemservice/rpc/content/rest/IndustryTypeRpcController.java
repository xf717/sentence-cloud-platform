package com.db.chaomaxs.systemservice.rpc.content.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.IndustryTypeRpcImpl;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.api.IndustryTypeApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class IndustryTypeRpcController implements IndustryTypeApi {

	@Autowired
	private IndustryTypeRpcImpl industryTypeRpc;

	@Override
	public BaseResponse save(@RequestBody IndustryTypeCreateReqDTO createReqDTO) {
		return industryTypeRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody IndustryTypeUpdateReqDTO updateReqDTO) {
		return industryTypeRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return industryTypeRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<IndustryTypeRespDTO> getIndustryTypeById(@PathVariable("id") Long id) {
		return industryTypeRpc.getIndustryTypeById(id);
	}

	@Override
	public ObjectRestResponse<List<IndustryTypeRespDTO>> listIndustryTypes(@RequestBody IndustryTypeListQueryReqDTO listQuery) {
		return industryTypeRpc.listIndustryTypes(listQuery);
	}

	@Override
	public TableResultResponse<IndustryTypeRespDTO> page(@RequestBody IndustryTypePageReqDTO pageReqDTO) {
		return industryTypeRpc.page(pageReqDTO);
	}

	/**
	 * 根据参数查询所有可显示分类
	 * @param listQuery  查询参数
	 * @return
	 */
	@Override
	public ObjectRestResponse listDisplayIndustry(@RequestBody IndustryTypeListQueryReqDTO listQuery) {
		return industryTypeRpc.listDisplayIndustry(listQuery);
	}

	/**
	 * 根据parentId查询数据,不分页
	 * @param parentId  查询参数
	 * @return
	 */
	@Override
	public ObjectRestResponse listIndustryByParentId(Long parentId) {
		return industryTypeRpc.listIndustryByParentId(parentId);
	}
}
