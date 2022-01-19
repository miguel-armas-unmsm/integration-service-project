package com.unmsm.fisi.photocopier.expose.web;

import com.unmsm.fisi.photocopier.business.StudentService;
import com.unmsm.fisi.photocopier.model.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/unmsm/fisi/photocopier/v1/students")
public class StudentController {

  private final StudentService studentService;

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<StudentDto>> findAll() {
    return ResponseEntity.ok(studentService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentDto> findById(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.findById(id));
  }
}
