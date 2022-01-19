package com.unmsm.fisi.integrationservice.business.impl;

import com.unmsm.fisi.integrationservice.business.DocumentService;
import com.unmsm.fisi.integrationservice.model.dto.DocumentDto;
import com.unmsm.fisi.integrationservice.repository.DocumentRepository;
import com.unmsm.fisi.integrationservice.util.mapper.DocumentMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

  private final DocumentRepository documentRepository;
  private final DocumentMapper documentMapper;

  @Override
  public Long save(DocumentDto document) {
    return documentRepository.save(documentMapper.toEntity(document)).getId();
  }

  @Override
  public DocumentDto findById(Long id) {
    return documentMapper.toDto(documentRepository.findById(id)
        .orElse(null));
  }

  @Override
  public List<DocumentDto> findAll() {
    return documentRepository.findAll()
        .stream()
        .map(documentMapper::toDto)
        .collect(Collectors.toList());
  }
}
