package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

  private Long id;
  private String code;
  private String name;
  private String incomeYear;
  private String careerName;
  private String facultyName;
  private String universityName;
  private String password;
  private String email;
}
