package com.db.chaomaxs.searchservice.rpc.position.dto;

import lombok.Data;

/**
 * @author momo
 * @date 2021-04-22 17:48
 */
@Data
public class PositionEsQueryReqDTO extends KeywordEsReqDTO {

  private String positionName;

  private Long positionTypeId;


  private String experience;


  private Long educationId;

  private String education;


  private Integer startSalary;


  private Integer endSalary;

  private String content;

  private String provinceCode;

  private String cityCode;

  private String areaCode;
}
