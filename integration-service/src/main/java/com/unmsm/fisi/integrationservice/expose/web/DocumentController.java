package com.unmsm.fisi.integrationservice.expose.web;

import static com.unmsm.fisi.integrationservice.util.mapper.CommonMapper.buildUriLocation;

import com.unmsm.fisi.integrationservice.business.DocumentService;
import com.unmsm.fisi.integrationservice.model.dto.DocumentDto;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/unmsm/esb/v1/documents")
public class DocumentController {

  private final DocumentService documentService;

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<DocumentDto>> findAll() {
    return ResponseEntity.ok(documentService.findAll());
  }

  @GetMapping("/pdf/{id}")
  public ResponseEntity<Resource> findFile(@PathVariable Long id) {
    DocumentDto document = documentService.findById(id);
    if (document == null || document.getFile() == null) {
      return ResponseEntity.notFound().build();
    }
    Resource file = new ByteArrayResource(document.getFile());

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .body(file);
  }

  @PostMapping
  public ResponseEntity<Void> save(@Valid DocumentDto document, BindingResult result,
                                   @RequestParam("file") MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
      document.setFile(file.getBytes());
    }

    Long id = documentService.save(document);
    return ResponseEntity.created(buildUriLocation.apply(id)).build();
  }

}
