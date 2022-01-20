package com.unmsm.fisi.photocopier.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "uploaded_documents")
public class UploadedDocument {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "pages")
  private Long pages;

  @Column(name = "pages_print")
  private String pagesPrint;

  @Lob
  @JsonIgnore
  private byte[] file;
}
