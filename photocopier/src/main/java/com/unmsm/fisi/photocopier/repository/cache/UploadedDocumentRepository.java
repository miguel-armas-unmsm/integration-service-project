package com.unmsm.fisi.photocopier.repository.cache;

import com.unmsm.fisi.photocopier.model.entity.UploadedDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadedDocumentRepository extends CrudRepository<UploadedDocument, Long> {

  List<UploadedDocument> findAll();
}
