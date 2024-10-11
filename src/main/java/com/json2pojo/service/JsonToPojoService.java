package com.json2pojo.service;

import com.json2pojo.configuration.JsonToPojoConfiguration;
import com.json2pojo.custom.CustomAnnotator;
import com.json2pojo.custom.CustomGenerationConfig;
import com.sun.codemodel.JCodeModel;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Service;

@Service
public class JsonToPojoService {

  public void convertJsonToJavaClass(JsonToPojoConfiguration jsonToPojoConfiguration) {
    Path inputJsonPath = Paths.get(jsonToPojoConfiguration.getBaseInputMainPath(),
        jsonToPojoConfiguration.getBaseInputFile());
    File inputJson = inputJsonPath.toFile();
    File outputPojoDirectory = new File(jsonToPojoConfiguration.getBaseOutputPath());
    outputPojoDirectory.mkdirs();
    JCodeModel jcodeModel = new JCodeModel();

    GenerationConfig config = new CustomGenerationConfig();

    SchemaMapper
        mapper =
        new SchemaMapper(new RuleFactory(config, new CustomAnnotator(), new SchemaStore()),
            new SchemaGenerator());
    try {
      mapper.generate(jcodeModel, inputJson.getName().replace(".json", ""),
          jsonToPojoConfiguration.getPackageName(), inputJson.toURI().toURL());

      jcodeModel.build(outputPojoDirectory);

    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
