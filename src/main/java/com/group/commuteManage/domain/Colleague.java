package com.group.commuteManage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Colleague {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 20)
  private String name;
  @Column(nullable = false)
  private boolean isTeamManager;
  @Column(nullable = false)
  private LocalDate enteringDay;
  @Column(nullable = false)
  private LocalDate birthday;

  public Colleague(String name, boolean isTeamManager, LocalDate enteringDay, LocalDate birthday) {
    this.name = name;
    this.isTeamManager = isTeamManager;
    this.enteringDay = enteringDay;
    this.birthday = birthday;
  }
}
