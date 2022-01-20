package com.unmsm.fisi.integrationservice.expose.web;

import com.unmsm.fisi.integrationservice.business.StudentService;
import com.unmsm.fisi.integrationservice.model.dto.StudentDto;
import java.io.IOException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/unmsm/esb/v1/students")
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

  @PostMapping
  public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto student) throws IOException {
    return ResponseEntity.ok(studentService.save(student));
  }

}
