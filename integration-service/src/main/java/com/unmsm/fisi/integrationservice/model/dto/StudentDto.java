package com.unmsm.fisi.integrationservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
