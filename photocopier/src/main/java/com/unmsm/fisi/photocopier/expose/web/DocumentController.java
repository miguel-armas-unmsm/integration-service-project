package com.unmsm.fisi.photocopier.expose.web;

import com.unmsm.fisi.photocopier.business.DocumentService;
import com.unmsm.fisi.photocopier.model.dto.DocumentDto;
import com.unmsm.fisi.photocopier.model.dto.UploadedDocumentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/unmsm/fisi/photocopier/v1")
public class DocumentController {

  private final DocumentService documentService;

  @GetMapping(value = "/uploaded-documents", produces = "application/json")
  public ResponseEntity<List<UploadedDocumentDto>> findAllUploadedDocuments() {
    return ResponseEntity.ok(documentService.findAllUploadedDocuments());
  }

  @PostMapping("/uploaded-documents")
  public ResponseEntity<UploadedDocumentDto> saveUploadedDocument(@Valid UploadedDocumentDto document, BindingResult result,
                                          @RequestParam("file") MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
      document.setFile(file.getBytes());
    }
    return ResponseEntity.ok(documentService.saveUploadedDocument(document));
  }

  @GetMapping("/uploaded-documents/pdf/{id}")
  public ResponseEntity<Resource> findUploadedDocumentById(@PathVariable Long id) {
    UploadedDocumentDto document = documentService.findUploadedDocumentById(id);
    if (document == null || document.getFile() == null) {
      return ResponseEntity.notFound().build();
    }
    Resource file = new ByteArrayResource(document.getFile());

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .body(file);
  }

  @GetMapping(value = "/managed-documents", produces = "application/json")
  public ResponseEntity<List<DocumentDto>> findAllManagedDocuments() {
    return ResponseEntity.ok(documentService.findAllManagedDocuments());
  }

  @GetMapping("/managed-documents/pdf/{id}")
  public ResponseEntity<Resource> findFile(@PathVariable Long id) {
    DocumentDto document = documentService.findManagedDocumentById(id);
    if (document == null || document.getFile() == null) {
      return ResponseEntity.notFound().build();
    }
    Resource file = new ByteArrayResource(document.getFile());

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .body(file);
  }

  @PostMapping("/managed-documents")
  public ResponseEntity<DocumentDto> save(@Valid DocumentDto document, BindingResult result,
                                   @RequestParam("file") MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
      document.setFile(file.getBytes());
    }
    return ResponseEntity.ok(documentService.saveManagedDocument(document));
  }

}
