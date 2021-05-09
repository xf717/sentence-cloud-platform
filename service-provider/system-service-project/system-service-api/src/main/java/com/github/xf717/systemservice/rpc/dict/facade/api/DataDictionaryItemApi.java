package com.github.xf717.systemservice.rpc.dict.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
public interface DataDictionaryItemApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryItem/save")
	BaseResponse save(@RequestBody DataDictionaryItemCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/dataDictionaryItem/update")
	BaseResponse update(@RequestBody DataDictionaryItemUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/dataDictionaryItem/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/dataDictionaryItem/get/{id}")
	ObjectRestResponse<DataDictionaryItemRespDTO> getDataDictionaryItemById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryItem/list")
	ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItems(
      @RequestBody DataDictionaryItemListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryItem/page")
	TableResultResponse<DataDictionaryItemRespDTO> page(
      @RequestBody DataDictionaryItemPageReqDTO pageReqDTO);

	/**
	 * 根据字典类型code集合查询字典项信息
	 * @param queryDTO
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryItem/get/dict/item")
	ObjectRestResponse getDictItem(@RequestBody @Valid DataDictionaryItemQueryReqDTO queryDTO);


	/**
	 * 根据ids获取对象
	 *
	 * @param queryDTO
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryItem/get/ids")
	ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItemByIds(
			@RequestBody @Valid DataDictionaryTypeListIdsReqDTO queryDTO);
}
