package com.group.commuteManage.controller;

import com.group.commuteManage.dto.response.TeamOverviewResponse;
import com.group.commuteManage.service.team.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/team")
public class TeamController {
  private final TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @ApiOperation(value ="팀 등록", notes= "팀 이름을 등록한다")
  @PostMapping("/create")
  public void teamCreate(@RequestParam String name, Model model){
     teamService.teamCreate(name);
  }

  @ApiOperation(value ="팀 조회", notes = "팀의 정보를 한 번에 조회한다")
  @GetMapping("/overview")
  public List<TeamOverviewResponse> teamOverview(){
    return teamService.teamOverview();
  }
//  @ApiOperation(value ="팀 수정", notes= "팀 이름을 수정한다")
//  @PostMapping("/create")
//  public void teamCreate(@RequestParam String name){
//    teamService.teamCreate(name);
//  }


}
