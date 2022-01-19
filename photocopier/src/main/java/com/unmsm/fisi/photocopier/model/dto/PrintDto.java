package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrintDto {

  Long id;
  int floor;
  String title;
  LocalDateTime date;
  String status;
}
