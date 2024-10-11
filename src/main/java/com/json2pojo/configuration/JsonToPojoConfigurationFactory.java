package com.json2pojo.configuration;

import com.json2pojo.enums.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonToPojoConfigurationFactory {

  private final SofascoreJsonToPojoConfiguration sofascoreConfig;
  private final FotmobJsonToPojoConfiguration fotmobConfig;

  @Autowired
  public JsonToPojoConfigurationFactory(SofascoreJsonToPojoConfiguration sofascoreConfig,
                                        FotmobJsonToPojoConfiguration fotmobConfig) {
    this.sofascoreConfig = sofascoreConfig;
    this.fotmobConfig = fotmobConfig;
  }

  public JsonToPojoConfiguration createJsonToPojoConfiguration(Website website) {
    switch (website) {
      case SOFASCORE:
        return sofascoreConfig;
      case FOTMOB:
        return fotmobConfig;
      default:
        throw new IllegalArgumentException("Unsupported EnumValue: " + website);
    }
  }
}
