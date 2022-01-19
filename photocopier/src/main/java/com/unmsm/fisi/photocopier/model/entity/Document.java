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
@Table(name = "managed_documents")
public class Document {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "description")
  private String description;

  @Column(name = "pages")
  private Long pages;

  @Lob
  @JsonIgnore
  private byte[] file;

  public Integer getFileHashCode() {
    return (this.file != null) ? this.getFileHashCode() : null;
  }
}
