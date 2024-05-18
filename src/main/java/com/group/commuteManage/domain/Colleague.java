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
  @Column(nullable = false, length = 20, name ="name")
  private String name;
  @Column(nullable = false, name ="isteammanager")
  private boolean isteammanager;
  @Column(nullable = false , name = "enteringday")
  private LocalDate enteringday;
  @Column(nullable = false , name ="birthday")
  private LocalDate birthday;

  public Colleague(String name, boolean isteammanager, LocalDate enteringday, LocalDate birthday) {
    this.name = name;
    this.isteammanager = isteammanager;
    this.enteringday = enteringday;
    this.birthday = birthday;
  }
}
