package com.group.commuteManage.controller;

import com.group.commuteManage.service.team.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/team")
public class TeamController {
  private final TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @ApiOperation(value ="팀 등록", notes= "팀 이름을 등록한다")
  @PostMapping("/create")
  public void teamCreate(@RequestParam String name){
    teamService.teamCreate(name);
  }

//  @ApiOperation(value ="팀 수정", notes= "팀 이름을 수정한다")
//  @PostMapping("/create")
//  public void teamCreate(@RequestParam String name){
//    teamService.teamCreate(name);
//  }


}
