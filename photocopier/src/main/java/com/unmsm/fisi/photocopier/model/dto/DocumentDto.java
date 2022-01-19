package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

  private Long id;
  private byte[] file;
  private String title;
  private String description;
  private String fileName;
  private Long pages;
}
