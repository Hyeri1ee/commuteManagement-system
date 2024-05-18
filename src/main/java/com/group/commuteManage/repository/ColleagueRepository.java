package com.group.commuteManage.repository;

import com.group.commuteManage.domain.Colleague;
import com.group.commuteManage.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ColleagueRepository extends JpaRepository<Colleague,Long> {
  List<Colleague> findByTeam(Team e);

  Colleague findByNameAndBirthday(String name, LocalDate birthday);
}
