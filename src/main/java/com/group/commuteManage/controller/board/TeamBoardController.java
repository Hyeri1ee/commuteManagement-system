package com.group.commuteManage.controller.board;

import com.group.commuteManage.domain.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/team")
public class TeamBoardController {

  @GetMapping("/create")
  public String createTeamPage(){
    return "createTeam";
  }

  @GetMapping("/overview1")
  public String overviewTeamPage(){
    return "overviewTeam";
  }


}
