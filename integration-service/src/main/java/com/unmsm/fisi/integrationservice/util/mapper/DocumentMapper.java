package com.unmsm.fisi.integrationservice.util.mapper;

import com.unmsm.fisi.integrationservice.model.dto.DocumentDto;
import com.unmsm.fisi.integrationservice.model.entity.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

  Document toEntity(DocumentDto documentDto);

  DocumentDto toDto(Document documentEntity);

}
