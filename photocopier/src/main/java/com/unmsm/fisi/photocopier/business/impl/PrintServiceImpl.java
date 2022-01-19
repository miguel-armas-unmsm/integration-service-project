package com.unmsm.fisi.photocopier.business.impl;

import com.unmsm.fisi.photocopier.business.DocumentService;
import com.unmsm.fisi.photocopier.business.PrintService;
import com.unmsm.fisi.photocopier.model.dto.DocumentDto;
import com.unmsm.fisi.photocopier.model.dto.PrintRequest;
import com.unmsm.fisi.photocopier.model.dto.PrintDto;
import com.unmsm.fisi.photocopier.model.dto.UploadedDocumentDto;
import com.unmsm.fisi.photocopier.repository.database.PrintRepository;
import com.unmsm.fisi.photocopier.util.PrintMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PrintServiceImpl implements PrintService {

  private final DocumentService documentService;
  private final PrintRepository printRepository;
  private final PrintMapper printMapper;



  @Override
  public PrintDto printDocument(PrintRequest printRequest) {

    PrintDto printDto = new PrintDto();
    Long id = 0L;

    if(printRequest.getOrigin().equals("UPLOADED")) {
      DocumentDto document = documentService.findManagedDocumentById(printRequest.getId());
      buildResponse.accept(printDto, document.getTitle());
      id = printRepository.save(printMapper.toEntity(printDto)).getId();
    }

    if(printRequest.getOrigin().equals("MANAGED")) {
      UploadedDocumentDto document = documentService.findUploadedDocumentById(printRequest.getId());
      buildResponse.accept(printDto, document.getFileName());
      id = printRepository.save(printMapper.toEntity(printDto)).getId();
    }

    printDto.setId(id);
    return printDto;
  }

  @Override
  public List<PrintDto> findAll() {
    return printRepository.findAll()
        .stream()
        .map(printMapper::toDto)
        .collect(Collectors.toList());
  }

  private static final BiConsumer<PrintDto, String> buildResponse = (printDto, title) -> {
    printDto.setTitle(title);
    printDto.setDate(LocalDateTime.now());
    printDto.setFloor((int)(Math.random()*2+1));
    printDto.setStatus("En progreso...");
  };
}
