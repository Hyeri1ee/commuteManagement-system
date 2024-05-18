package com.group.commuteManage.service.colleague;

import com.group.commuteManage.domain.Colleague;
import com.group.commuteManage.dto.ColleagueRequest;
import com.group.commuteManage.repository.ColleagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColleagueService {
  private final ColleagueRepository colleagueRepository;

  public ColleagueService(ColleagueRepository colleagueRepository) {
    this.colleagueRepository = colleagueRepository;
  }

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
}
