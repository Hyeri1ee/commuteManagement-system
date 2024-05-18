package com.group.commuteManage.dto.request;

import lombok.Getter;

import java.time.LocalDate;
@Getter

public class ColleagueRequest {

  private String name;
  private boolean isteammanager;
  private LocalDate enteringday;
  private LocalDate birthday;

}
