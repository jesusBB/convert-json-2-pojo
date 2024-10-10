package com.json2pojo;

import com.sun.codemodel.JCodeModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.json2pojo.custom.CustomGenerationConfig;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConvertJson2PojoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConvertJson2PojoApplication.class, args);
    String packageName = "com.json2pojo.sofascore.teams";
    String baseInputPath = "src/main/resources";
    String baseOutputPath = "src/main/java";

    File inputJson = new File(
        baseInputPath + File.separator + "sofascore" + File.separator + "team-schema2.json");
    File outputPojoDirectory = new File(baseOutputPath /*+ File.separator  + "convertedPojo"*/);
    outputPojoDirectory.mkdirs();
    try {
      convertJsonToJavaClass(inputJson.toURI().toURL(), outputPojoDirectory, packageName,
          inputJson.getName().replace(".json", ""));
    } catch (IOException e) {
      System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory,
                                            String packageName, String javaClassName)
      throws IOException {
    JCodeModel jcodeModel = new JCodeModel();

    GenerationConfig config = new CustomGenerationConfig();
   // GenerationConfig config = new DefaultGenerationConfig();

    SchemaMapper
        mapper =
        new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()),
            new SchemaGenerator());
    mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

    jcodeModel.build(outputJavaClassDirectory);

  }

}
