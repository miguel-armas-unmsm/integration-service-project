package com.unmsm.fisi.photocopier.business;

import com.unmsm.fisi.photocopier.model.dto.DocumentDto;
import com.unmsm.fisi.photocopier.model.dto.UploadedDocumentDto;
import java.util.List;

public interface DocumentService {

  DocumentDto saveManagedDocument(DocumentDto document);

  DocumentDto findManagedDocumentById(Long id);

  List<DocumentDto> findAllManagedDocuments();

  UploadedDocumentDto saveUploadedDocument(UploadedDocumentDto document);

  UploadedDocumentDto findUploadedDocumentById(Long id);

  List<UploadedDocumentDto> findAllUploadedDocuments();

}
