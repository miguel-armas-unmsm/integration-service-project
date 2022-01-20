package com.unmsm.fisi.photocopier.expose.web;

import com.unmsm.fisi.photocopier.business.PrintService;
import com.unmsm.fisi.photocopier.model.dto.PrintRequest;
import com.unmsm.fisi.photocopier.model.dto.PrintDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/unmsm/fisi/photocopier/v1/prints")
public class PrintController {

  private final PrintService printService;

  @PostMapping
  public ResponseEntity<PrintDto> printFromManagedDocument(@Valid @RequestBody PrintRequest printRequest) {
    return ResponseEntity.ok(printService.printDocument(printRequest));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<PrintDto>> findAll() {
    return ResponseEntity.ok(printService.findAll());
  }
}
