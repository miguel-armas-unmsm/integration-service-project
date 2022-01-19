package com.unmsm.fisi.photocopier.business.impl;

import com.unmsm.fisi.photocopier.business.DocumentService;
import com.unmsm.fisi.photocopier.model.dto.DocumentDto;
import com.unmsm.fisi.photocopier.model.dto.UploadedDocumentDto;
import com.unmsm.fisi.photocopier.repository.cache.UploadedDocumentRepository;
import com.unmsm.fisi.photocopier.repository.third.proxy.ManagedDocumentRepository;
import com.unmsm.fisi.photocopier.util.DocumentManagementMapper;
import com.unmsm.fisi.photocopier.util.UploadedDocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

  private final ManagedDocumentRepository managedDocumentRepository;
  private final DocumentManagementMapper documentManagementMapper;

  private final UploadedDocumentRepository uploadedDocumentRepository;
  private final UploadedDocumentMapper uploadedDocumentMapper;

  @Override
  public DocumentDto saveManagedDocument(DocumentDto document) {
    return documentManagementMapper.toDto(managedDocumentRepository
        .save(documentManagementMapper.toEntity(document)));
  }

  @Override
  public DocumentDto findManagedDocumentById(Long id) {
    return documentManagementMapper.toDto(managedDocumentRepository.findById(id)
        .orElse(null));
  }

  @Override
  public List<DocumentDto> findAllManagedDocuments() {
    return managedDocumentRepository.findAll()
        .stream()
        .map(documentManagementMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public UploadedDocumentDto saveUploadedDocument(UploadedDocumentDto document) {
    return uploadedDocumentMapper.toDto(uploadedDocumentRepository
        .save(uploadedDocumentMapper.toEntity(document)));
  }

  @Override
  public UploadedDocumentDto findUploadedDocumentById(Long id) {
    return uploadedDocumentMapper.toDto(uploadedDocumentRepository.findById(id)
        .orElse(null));
  }

  @Override
  public List<UploadedDocumentDto> findAllUploadedDocuments() {
    return uploadedDocumentRepository.findAll()
        .stream()
        .map(uploadedDocumentMapper::toDto)
        .collect(Collectors.toList());
  }
}
