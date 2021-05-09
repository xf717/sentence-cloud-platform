package com.github.xf717.userweb.controller.dict;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import com.github.xf717.userweb.controller.dict.dto.DataDictionaryItemQueryDTO;
import com.github.xf717.userweb.manager.dict.DataDictionaryItemManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app端数据字典项信息表
 *
 * @author ding
 * @date 2021-03-29 17:42:11
 */
@Api(value = "数据字典项信息表", description = "数据字典项信息表", tags = "数据字典项信息")
@RestController
@RequestMapping("/rest/dataDictionaryItem")
public class DataDictionaryItemController {

  @Autowired
  private DataDictionaryItemManager dataDictionaryItemManager;


  @ApiOperation(value = "根据code获取字典项信息", nickname = "getDictItem")
  @PostMapping("/list")
  @IgnoreUserToken
  public ObjectRestResponse listDictItem(@Valid @RequestBody DataDictionaryItemQueryDTO queryDTO){
    return dataDictionaryItemManager.getDictItem(queryDTO);
  }

}
