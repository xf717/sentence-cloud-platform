package com.github.xf717.managementweb.convert.auth;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.BaseGroupVO;
import com.github.xf717.managementweb.controller.auth.vo.GroupTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.GroupUsersVO;
import com.github.xf717.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.GroupTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupConvert {

  BaseGroupConvert INSTANCE = Mappers.getMapper(
      BaseGroupConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupCreateReqDTO convert(BaseGroupAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupUpdateReqDTO convert(BaseGroupUpdateDTO updateDTO);

  @Mappings({})
  BaseGroupListQueryReqDTO convert(BaseGroupDTO baseGroupDTO);

  /**
   * BO convert VO
   *
   * @param baseGroupRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupVO convert(BaseGroupRespDTO baseGroupRespDTO);

  @Mappings({})
  List<BaseGroupVO> convertList(List<BaseGroupRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseGroupVO> convert(
      TableResultResponse<BaseGroupRespDTO> tableResultResponse);

  @Mappings({})
  BaseGroupPageReqDTO convert(BaseGroupPageDTO baseGroupPageDTO);

  /**
   * 转换权限菜单VO
   *
   * @param list
   * @return
   */
  List<AuthorityMenuTreeVO> convertAuthorityMenuTreeListVO(List<AuthorityMenuTreeRespDTO> list);

  /**
   * 数据转换
   *
   * @param groupRespDTO
   * @return
   */
  @Mappings({
      @Mapping(source = "name", target = "label")
  })
  GroupTreeRespDTO convertGroupTree(BaseGroupRespDTO groupRespDTO);

  /**
   * 数据转换 list
   *
   * @param baseGroupRespDTOList
   * @return
   */
  List<GroupTreeRespDTO> convertGroupTreeList(List<BaseGroupRespDTO> baseGroupRespDTOList);

  /**
   * 数据转换  DTO list 转 VO list
   *
   * @param groupTreeRespDTOList
   * @return
   */
  List<GroupTreeVO> convertGroupTreeVOList(List<GroupTreeRespDTO> groupTreeRespDTOList);

  /**
   * 用户转换
   *
   * @param groupUsersRespDTO
   * @return
   */
  GroupUsersVO convert(GroupUsersRespDTO groupUsersRespDTO);

}
