package com.unmsm.fisi.integrationservice.repository;

import com.unmsm.fisi.integrationservice.model.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

  List<Document> findAll();
}
