package com.unmsm.fisi.photocopier.repository.third.config;

import com.unmsm.fisi.photocopier.repository.third.proxy.StudentApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RestClientConfig {

  @Value("${application.client.integration-service.baseurl}")
  private String integrationServiceUrl;

  @Bean
  StudentApi studentApi(OkHttpClient.Builder builder) {
    return new Retrofit.Builder()
        .baseUrl(integrationServiceUrl)
        .client(client().build())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(StudentApi.class);
  }

  @Bean
  OkHttpClient.Builder client() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    return new OkHttpClient.Builder().addInterceptor(interceptor);
  }
}
