package com.unmsm.fisi.photocopier.business.impl;

import com.unmsm.fisi.photocopier.business.StudentService;
import com.unmsm.fisi.photocopier.model.dto.StudentDto;
import com.unmsm.fisi.photocopier.repository.third.proxy.StudentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

}
