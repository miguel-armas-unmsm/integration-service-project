package com.unmsm.fisi.photocopier.repository.database;

import com.unmsm.fisi.photocopier.model.entity.Print;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintRepository extends CrudRepository<Print, Long> {

  List<Print> findAll();
}
