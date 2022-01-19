package com.unmsm.fisi.photocopier.business;

import com.unmsm.fisi.photocopier.model.dto.PrintRequest;
import com.unmsm.fisi.photocopier.model.dto.PrintDto;

import java.util.List;

public interface PrintService {

  PrintDto printDocument(PrintRequest printRequest);

  List<PrintDto> findAll();
}
