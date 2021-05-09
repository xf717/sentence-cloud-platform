package com.github.xf717.systemservice.rpc.notice.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 通知信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
public interface NoticeInformationApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformation/save")
	BaseResponse save(@RequestBody NoticeInformationCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/noticeInformation/update")
	BaseResponse update(@RequestBody NoticeInformationUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/noticeInformation/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/noticeInformation/get/{id}")
	ObjectRestResponse<NoticeInformationRespDTO> getNoticeInformationById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformation/list")
	ObjectRestResponse<List<NoticeInformationRespDTO>> listNoticeInformations(
      @RequestBody NoticeInformationListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformation/page")
	TableResultResponse<NoticeInformationRespDTO> page(
      @RequestBody NoticeInformationPageReqDTO pageReqDTO);

}
