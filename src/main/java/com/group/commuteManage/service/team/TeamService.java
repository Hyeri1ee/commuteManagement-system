package com.group.commuteManage.service.team;

import com.group.commuteManage.domain.Team;
import com.group.commuteManage.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {
  private final TeamRepository teamRepository;

  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }
  @Transactional
  public void teamCreate(String name) {
    teamRepository.save(new Team(name));
  }
}
