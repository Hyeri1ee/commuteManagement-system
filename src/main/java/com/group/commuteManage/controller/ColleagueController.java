package com.group.commuteManage.controller;

import com.group.commuteManage.dto.request.ColleagueRequest;
import com.group.commuteManage.dto.response.ColleagueOverviewResponse;
import com.group.commuteManage.service.colleague.ColleagueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/colleague")
public class ColleagueController {

  private final ColleagueService colleagueService;

  public ColleagueController(ColleagueService colleagueService) {
    this.colleagueService = colleagueService;
  }

  @ApiOperation(value ="직원 등록", notes= "직원 정보를 등록한다")
  @PostMapping("/create")
  public void createColleague(@RequestBody ColleagueRequest request){
    colleagueService.create(request);
  }

  @ApiOperation(value ="팀 배정", notes= "직원을 팀에 등록한다")
  @PostMapping("/putTeam")
  public void putColleageTeam(@RequestParam String name, @RequestParam LocalDate birthday, @RequestParam Long teamId){
    colleagueService.putTeam(name,birthday,teamId);
  }

  @ApiOperation(value="직원 조회", notes ="모든 직원의 정보를 한 번에 조회할 수 있어야 합니다.")
  @GetMapping("/overview")
  public List<ColleagueOverviewResponse> colleagueOverview(){
    return colleagueService.overview();
  }





}
