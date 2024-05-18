package com.group.commuteManage.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ColleagueRequest {

  private String name;
  private boolean isTeamManager;
  private LocalDate enteringDay;
  private LocalDate birthday;

}
