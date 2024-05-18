package com.group.commuteManage.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ColleagueOverviewResponse {
  private String name;
  private String teamName;
  private String role;
  private LocalDate birthday;
  private LocalDate workStartDate;

  public ColleagueOverviewResponse(String name, String teamName, String role,
                                   LocalDate birthday, LocalDate workStartDate) {
    this.name = name;
    this.teamName = teamName;
    this.role = role;
    this.birthday = birthday;
    this.workStartDate = workStartDate;
  }
}
