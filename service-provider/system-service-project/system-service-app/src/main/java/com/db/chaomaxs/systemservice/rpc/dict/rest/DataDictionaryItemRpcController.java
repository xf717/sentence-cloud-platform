package com.db.chaomaxs.systemservice.rpc.dict.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.dict.DataDictionaryItemRpcImpl;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.api.DataDictionaryItemApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@RestController
public class DataDictionaryItemRpcController implements DataDictionaryItemApi {

	@Autowired
	private DataDictionaryItemRpcImpl dataDictionaryItemRpc;

	@Override
	public BaseResponse save(@RequestBody DataDictionaryItemCreateReqDTO createReqDTO) {
		return dataDictionaryItemRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody DataDictionaryItemUpdateReqDTO updateReqDTO) {
		return dataDictionaryItemRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return dataDictionaryItemRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<DataDictionaryItemRespDTO> getDataDictionaryItemById(@PathVariable("id") Long id) {
		return dataDictionaryItemRpc.getDataDictionaryItemById(id);
	}

	@Override
	public ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItems(@RequestBody DataDictionaryItemListQueryReqDTO listQuery) {
		return dataDictionaryItemRpc.listDataDictionaryItems(listQuery);
	}

	@Override
	public TableResultResponse<DataDictionaryItemRespDTO> page(@RequestBody DataDictionaryItemPageReqDTO pageReqDTO) {
		return dataDictionaryItemRpc.page(pageReqDTO);
	}

	/**
	 * 根据字典类型code集合查询字典项信息
	 * @param queryDTO
	 * @return
	 */
	@Override
	public ObjectRestResponse getDictItem(DataDictionaryItemQueryReqDTO queryDTO) {
		return dataDictionaryItemRpc.getDictItem(queryDTO);
	}


	/**
	 * 根据ids获取对象
	 *
	 * @param queryDTO
	 * @return
	 */

	@Override
	public ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItemByIds(
			DataDictionaryTypeListIdsReqDTO queryDTO) {
		return  dataDictionaryItemRpc.listDataDictionaryItemByIds(queryDTO);

	}
}
