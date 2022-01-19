package com.unmsm.fisi.photocopier.util;

import com.unmsm.fisi.photocopier.model.dto.PrintDto;
import com.unmsm.fisi.photocopier.model.entity.Print;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrintMapper {

  Print toEntity(PrintDto printDto);

  PrintDto toDto(Print printEntity);
}
