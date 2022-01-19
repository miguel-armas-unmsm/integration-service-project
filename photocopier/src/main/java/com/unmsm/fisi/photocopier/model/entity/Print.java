package com.unmsm.fisi.photocopier.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prints")
public class Print {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "floor")
  int floor;

  @Column(name = "title")
  String title;

  @Column(name = "date")
  LocalDateTime date;

  @Column(name = "status")
  String status;
}
