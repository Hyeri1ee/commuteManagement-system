package com.group.commuteManage.dto.response;

import lombok.Getter;

@Getter
public class TeamOverviewResponse {
  private String name; //팀 이름
  private String manager; //팀 매니저 이름 (없을 경우 null)
  private long memberCount; //팀 인원 수

  public TeamOverviewResponse(String name, String manager, long memberCount) {
    this.name = name;
    this.manager = manager;
    this.memberCount = memberCount;
  }
}