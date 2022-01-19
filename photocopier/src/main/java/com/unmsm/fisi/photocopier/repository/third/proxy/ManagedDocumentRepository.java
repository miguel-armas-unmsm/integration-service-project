package com.unmsm.fisi.photocopier.repository.third.proxy;

import com.unmsm.fisi.photocopier.model.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManagedDocumentRepository extends CrudRepository<Document, Long> {

  List<Document> findAll();

}
