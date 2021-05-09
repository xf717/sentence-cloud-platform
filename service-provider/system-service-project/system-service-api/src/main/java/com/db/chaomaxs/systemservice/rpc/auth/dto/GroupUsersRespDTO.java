package com.db.chaomaxs.systemservice.rpc.auth.dto;

import java.util.List;

/**
 * @author xiaofeng
 * @date 2017/6/18
 */
public class GroupUsersRespDTO {

  List<BaseUserRespDTO> members;
  List<BaseUserRespDTO> leaders;

  public GroupUsersRespDTO() {
  }

  public GroupUsersRespDTO(List<BaseUserRespDTO> members, List<BaseUserRespDTO> leaders) {
    this.members = members;
    this.leaders = leaders;
  }

  public List<BaseUserRespDTO> getMembers() {
    return members;
  }

  public void setMembers(List<BaseUserRespDTO> members) {
    this.members = members;
  }

  public List<BaseUserRespDTO> getLeaders() {
    return leaders;
  }

  public void setLeaders(List<BaseUserRespDTO> leaders) {
    this.leaders = leaders;
  }
}
