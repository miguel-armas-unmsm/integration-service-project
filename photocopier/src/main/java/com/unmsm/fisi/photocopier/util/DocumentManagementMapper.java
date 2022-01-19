package com.unmsm.fisi.photocopier.util;

import com.unmsm.fisi.photocopier.model.dto.DocumentDto;
import com.unmsm.fisi.photocopier.model.entity.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentManagementMapper {

  Document toEntity(DocumentDto documentDto);

  DocumentDto toDto(Document documentEntity);

}
