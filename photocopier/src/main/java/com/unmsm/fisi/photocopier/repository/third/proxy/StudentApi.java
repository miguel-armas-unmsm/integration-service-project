package com.unmsm.fisi.photocopier.repository.third.proxy;

import com.unmsm.fisi.photocopier.model.dto.StudentDto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import java.util.List;

public interface StudentApi {

  @Headers({"Accept: application/json"})
  @GET("students")
  Observable<List<StudentDto>> findAll();

  @Headers({"Accept: application/json"})
  @GET("students/{id}")
  Observable<StudentDto> findById(@Path("id") Long id);
}
