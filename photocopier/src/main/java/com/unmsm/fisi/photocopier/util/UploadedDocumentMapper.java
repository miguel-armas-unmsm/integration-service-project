package com.unmsm.fisi.photocopier.util;

import com.unmsm.fisi.photocopier.model.dto.UploadedDocumentDto;
import com.unmsm.fisi.photocopier.model.entity.UploadedDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UploadedDocumentMapper {

  UploadedDocument toEntity(UploadedDocumentDto documentDto);

  UploadedDocumentDto toDto(UploadedDocument documentEntity);
}
