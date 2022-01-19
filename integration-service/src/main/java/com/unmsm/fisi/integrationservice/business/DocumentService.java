package com.unmsm.fisi.integrationservice.business;

import com.unmsm.fisi.integrationservice.model.dto.DocumentDto;

import java.util.List;

public interface DocumentService {

  Long save(DocumentDto document);

  DocumentDto findById(Long id);

  List<DocumentDto> findAll();

}
