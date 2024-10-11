package com.json2pojo.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@ConfigurationProperties(prefix = "json2pojo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class JsonToPojoConfiguration {

  private String packageName;
  private String baseInputMainPath;
  private String baseOutputPath;
  private String baseInputFile;

}