package com.unmsm.fisi.integrationservice.business.impl;

import com.unmsm.fisi.integrationservice.business.StudentService;
import com.unmsm.fisi.integrationservice.model.dto.StudentDto;
import com.unmsm.fisi.integrationservice.repository.StudentRepository;
import com.unmsm.fisi.integrationservice.util.mapper.StudentMapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @Override
  public StudentDto save(StudentDto document) {
    return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(document)));
  }

  @Override
  public StudentDto findById(Long id) {
    return studentMapper.toDto(studentRepository.findById(id)
        .orElse(null));
  }

  @Override
  public List<StudentDto> findAll() {
    return studentRepository.findAll()
        .stream()
        .map(studentMapper::toDto)
        .collect(Collectors.toList());
  }
}
