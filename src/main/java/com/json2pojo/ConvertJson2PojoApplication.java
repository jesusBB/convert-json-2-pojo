package com.json2pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties(SofascoreJsonToPojoConfiguration.class)
public class ConvertJson2PojoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConvertJson2PojoApplication.class, args);
  }

}
