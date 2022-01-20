package com.unmsm.fisi.photocopier.business.impl;

import com.unmsm.fisi.photocopier.business.StudentService;
import com.unmsm.fisi.photocopier.model.dto.LoginRequest;
import com.unmsm.fisi.photocopier.model.dto.StudentDto;
import com.unmsm.fisi.photocopier.repository.third.proxy.StudentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.BiPredicate;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentApi studentApi;

  @Override
  public StudentDto findById(Long id) {
    return studentApi.findById(id).blockingFirst();
  }

  @Override
  public List<StudentDto> findAll() {
    return studentApi.findAll().blockingFirst();
  }

  @Override
  public StudentDto login(LoginRequest loginRequest) {
    return studentApi.findAll()
        .blockingFirst()
        .stream()
        .filter(student -> isStudent.test(loginRequest, student))
        .findFirst()
        .orElse(StudentDto.builder()
            .name("¡Correo o contraseña incorrecto!")
            .build());
  }

  private static BiPredicate<LoginRequest, StudentDto> isStudent = (loginRequest, student) ->
     loginRequest.getEmail().equals(student.getEmail())
        && loginRequest.getPassword().equals(student.getPassword());

}
