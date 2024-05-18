package com.group.commuteManage.service.team;

import com.group.commuteManage.domain.Colleague;
import com.group.commuteManage.domain.Team;
import com.group.commuteManage.dto.response.TeamOverviewResponse;
import com.group.commuteManage.repository.ColleagueRepository;
import com.group.commuteManage.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
  private final TeamRepository teamRepository;
  private final ColleagueRepository colleagueRepository;

  public TeamService(TeamRepository teamRepository, ColleagueRepository colleagueRepository) {
    this.teamRepository = teamRepository;
    this.colleagueRepository = colleagueRepository;
  }
  @Transactional
  public void teamCreate(String name) {
    teamRepository.save(new Team(name));
  }

  @Transactional
  public List<TeamOverviewResponse> teamOverview() {
    List<Team> teams = teamRepository.findAll();

    List<TeamOverviewResponse> overviews = teams.stream()
            .map(e -> {
              String manager = null;
              long memberCount = 0;
              List<Colleague> colleagues = colleagueRepository.findByTeam(e);
              Optional<String> managerName = colleagues.stream()
                      .filter(Colleague::isIsteammanager)
                      .map(Colleague::getName)
                      .findFirst();
              manager = managerName.orElse(null);
              memberCount = colleagues.size();

              return new TeamOverviewResponse(e.getName(), manager, memberCount);
            })
            .collect(Collectors.toList());

    return overviews;
  }

}
