package com.db.chaomaxs.managementweb.convert.auth;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseMenuAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseMenuDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseMenuPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseMenuUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseMenuVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.MenuTreeVO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.MenuTreeRespDTO;
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
public interface BaseMenuConvert {

  BaseMenuConvert INSTANCE = Mappers.getMapper(
      BaseMenuConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseMenuCreateReqDTO convert(BaseMenuAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseMenuUpdateReqDTO convert(BaseMenuUpdateDTO updateDTO);

  /**
   * BaseMenuDTO 转  BaseMenuListQueryReqDTO
   *
   * @param baseMenuDTO
   * @return
   */
  @Mappings({})
  BaseMenuListQueryReqDTO convert(BaseMenuDTO baseMenuDTO);

  /**
   * baseMenuRespDTO convert VO
   *
   * @param baseMenuRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseMenuVO convert(BaseMenuRespDTO baseMenuRespDTO);

  /**
   * listResp 转 list vo
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<BaseMenuVO> convertList(List<BaseMenuRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseMenuVO> convert(
      TableResultResponse<BaseMenuRespDTO> tableResultResponse);

  @Mappings({})
  BaseMenuPageReqDTO convert(BaseMenuPageDTO baseMenuPageDTO);


  List<MenuTreeVO> convert(List<MenuTreeRespDTO> list);

  //  @Mappings({
//      @Mapping(source = "title", target = "label")
//  })
  MenuTreeVO convertTree(BaseMenuRespDTO baseMenuRespDTO);

  /**
   * 数据转换
   *
   * @param menuRespDTOList
   * @return
   */
  @Mappings({})
  List<MenuTreeVO> convertTreeList(List<BaseMenuRespDTO> menuRespDTOList);

  /**
   * 数据转换
   *
   * @param baseMenuRespDTO
   * @return
   */
  @Mappings({
      @Mapping(source = "title", target = "text")
  })
  AuthorityMenuTreeRespDTO convertAuthorityMenuTree(BaseMenuRespDTO baseMenuRespDTO);

  /**
   * 权限TREE 转换
   *
   * @param list
   * @return
   */
  List<AuthorityMenuTreeRespDTO> convertAuthorityMenuTreeList(List<BaseMenuRespDTO> list);

  /**
   * 转换权限菜单VO
   *
   * @param list
   * @return
   */
  List<AuthorityMenuTreeVO> convertAuthorityMenuTreeListVO(List<AuthorityMenuTreeRespDTO> list);

}
