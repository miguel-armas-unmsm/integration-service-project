package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrintRequest {

  Long id;
  String origin;
}
