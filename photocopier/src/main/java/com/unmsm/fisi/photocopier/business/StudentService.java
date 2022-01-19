package com.unmsm.fisi.photocopier.business;

import com.unmsm.fisi.photocopier.model.dto.StudentDto;
import java.util.List;

public interface StudentService {

  StudentDto findById(Long id);

  List<StudentDto> findAll();
}
