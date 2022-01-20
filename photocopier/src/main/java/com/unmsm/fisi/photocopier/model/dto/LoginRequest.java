package com.unmsm.fisi.photocopier.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  private String email;
  private String password;

}
