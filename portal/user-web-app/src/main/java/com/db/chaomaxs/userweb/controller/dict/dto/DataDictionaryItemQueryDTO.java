package com.db.chaomaxs.userweb.controller.dict.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DataDictionaryItemQueryDTO", description = "查询数据字典项信息表")
public class DataDictionaryItemQueryDTO {

  @ApiModelProperty(name = "codes",value = "10001:技能掌握程度、10002:求职状态、10003:求职方常用语、"
      + " 10004: 求职方打招呼语、10005:人员规模、10006:融资阶段、10007:休息时间、10008:加班情况、10009:招聘方常用语、"
      + "10010:招聘方打招呼语、10011:薪资范围、10012:工作经验、10013:学历、10014:积分说明、10015:积分类型、10016:通知发布类型、"
      + "10017:通知显示方式、10018:问题分类、10019:热门城市、10020:发布平台、10021:高校",example = "10001")
  @NotEmpty
  private List<String> codes;
}
