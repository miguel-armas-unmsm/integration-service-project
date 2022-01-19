package com.unmsm.fisi.integrationservice.business;

import com.unmsm.fisi.integrationservice.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

  StudentDto save(StudentDto document);

  StudentDto findById(Long id);

  List<StudentDto> findAll();

}
