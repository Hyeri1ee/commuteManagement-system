package com.group.commuteManage.controller;

import com.group.commuteManage.dto.ColleagueRequest;
import com.group.commuteManage.service.colleague.ColleagueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
