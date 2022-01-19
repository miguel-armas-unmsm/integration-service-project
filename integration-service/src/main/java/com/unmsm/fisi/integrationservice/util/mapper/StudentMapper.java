package com.unmsm.fisi.integrationservice.util.mapper;

import com.unmsm.fisi.integrationservice.model.dto.StudentDto;
import com.unmsm.fisi.integrationservice.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  Student toEntity(StudentDto studentDto);

  StudentDto toDto(Student studentEntity);

}
