package com.db.chaomaxs.systemservice.rpc.notice.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理通知信息_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
public interface NoticeInformationExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformationExtend/save")
	BaseResponse save(@RequestBody NoticeInformationExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/noticeInformationExtend/update")
	BaseResponse update(@RequestBody NoticeInformationExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/noticeInformationExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/noticeInformationExtend/get/{id}")
	ObjectRestResponse<NoticeInformationExtendRespDTO> getNoticeInformationExtendById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformationExtend/list")
	ObjectRestResponse<List<NoticeInformationExtendRespDTO>> listNoticeInformationExtends(
      @RequestBody NoticeInformationExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/noticeInformationExtend/page")
	TableResultResponse<NoticeInformationExtendRespDTO> page(
      @RequestBody NoticeInformationExtendPageReqDTO pageReqDTO);

}
