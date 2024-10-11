package com.json2pojo.controller;

import com.json2pojo.configuration.JsonToPojoConfiguration;
import com.json2pojo.configuration.JsonToPojoConfigurationFactory;
import com.json2pojo.enums.Website;
import com.json2pojo.service.JsonToPojoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonToPojoController {

  private final JsonToPojoService jsonToPojoService;
  private final JsonToPojoConfigurationFactory jsonToPojoConfigurationFactory;

  public JsonToPojoController(JsonToPojoService jsonToPojoService,
                              JsonToPojoConfigurationFactory jsonToPojoConfigurationFactory) {
    this.jsonToPojoService = jsonToPojoService;
    this.jsonToPojoConfigurationFactory = jsonToPojoConfigurationFactory;
  }

  @GetMapping(value = "/convert/{website}")
  public ResponseEntity<String> convertJsonToJavaClass(@PathVariable String website) {
    JsonToPojoConfiguration jsonToPojoConfiguration =
        jsonToPojoConfigurationFactory.createJsonToPojoConfiguration(
            Website.getWebsiteFromString(website));
    jsonToPojoService.convertJsonToJavaClass(jsonToPojoConfiguration);
    return ResponseEntity.ok("All good");
  }
}
