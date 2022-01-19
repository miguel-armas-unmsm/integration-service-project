package com.unmsm.fisi.integrationservice.util.mapper;

import java.net.URI;
import java.util.function.Function;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class CommonMapper {

  private CommonMapper() {}

    public static Function<Long, URI> buildUriLocation = id -> ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();
}
