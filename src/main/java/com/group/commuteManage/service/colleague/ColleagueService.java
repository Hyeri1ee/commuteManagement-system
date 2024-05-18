package com.group.commuteManage.service.colleague;

import com.group.commuteManage.domain.Colleague;
import com.group.commuteManage.domain.Team;
import com.group.commuteManage.dto.request.ColleagueRequest;
import com.group.commuteManage.dto.response.ColleagueOverviewResponse;
import com.group.commuteManage.repository.ColleagueRepository;
import com.group.commuteManage.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColleagueService {
  private final ColleagueRepository colleagueRepository;
  private final TeamRepository teamRepository;

  public ColleagueService(ColleagueRepository colleagueRepository, TeamRepository teamRepository) {
    this.colleagueRepository = colleagueRepository;
    this.teamRepository = teamRepository;
  }

  @Transactional
  public void create(ColleagueRequest request) {
    //동일인 등록 예외 처리 : 이름, 생일이 모두 같으면 동일인으로 처리
    List<Colleague>  colleagues  = colleagueRepository.findAll();
//    for (Colleague e : colleagues)
//      if (e.getName().equals(request.getName()) && e.getBirthday().equals(request.getBirthday()))
//        throw new IllegalArgumentException("동일인이 이미 등록되어있습니다.");
    //람다식 형태로 작성하기 위해 stream()함수를 사용
    colleagues.stream()
            .filter(e -> e.getName().equals(request.getName()) && e.getBirthday().equals(request.getBirthday()))
            .findAny()
            .ifPresent(e -> new IllegalAccessError("동일인이 이미 등록되어있습니다."));
    //db에 등록
    colleagueRepository.save(new Colleague(request.getName(),request.isIsteammanager(),
            request.getEnteringday(),request.getBirthday()));
  }

  @Transactional
  public void putTeam(String name, LocalDate birthday, Long teamId) {
    Colleague colleague = colleagueRepository.findByNameAndBirthday(name, birthday);
    Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + teamId));
    colleague.setTeam(team);
  }

  public List<ColleagueOverviewResponse> overview() {
    List<Colleague> colleagues = colleagueRepository.findAll();

    List<ColleagueOverviewResponse> overviews = colleagues.stream()
            .map(
                    e->{
                      String name = e.getName();
                      String team = e.getTeam().getName();
                      String role = (e.isIsteammanager()? "Manager": "Member");
                      LocalDate birthday = e.getBirthday();
                      LocalDate workStartDate = e.getEnteringday();

                      return new ColleagueOverviewResponse(name,team,role,birthday,workStartDate);
                    }
            )
            .collect(Collectors.toList());
    return overviews;
  }
}
