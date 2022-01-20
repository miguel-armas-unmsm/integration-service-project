package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadedDocumentDto {

  private Long id;
  private byte[] file;
  private String fileName;
  private Long pages;
  private String pagesPrint;
}
