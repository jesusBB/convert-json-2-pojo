package com.json2pojo.custom;

import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.SourceType;

public class CustomGenerationConfig extends DefaultGenerationConfig {

  @Override
  public boolean isGenerateBuilders() {
    return false;
  }

  @Override
  public boolean isIncludeSetters() {
    return false;
  }

  @Override
  public boolean isIncludeGetters() {
    return false;
  }

  @Override
  public boolean isIncludeToString() {
    return false;
  }

  @Override
  public boolean isIncludeHashcodeAndEquals() {
    return false;
  }

  @Override
  public boolean isIncludeGeneratedAnnotation() {
    return false;
  }

  @Override
  public boolean isIncludeJsr303Annotations() {
    return false;
  }

  @Override
  public boolean isIncludeJsr305Annotations() {
    return false;
  }

  @Override
  public boolean isIncludeAllPropertiesConstructor() {
    return false;
  }
  @Override
  public Class<? extends Annotator> getCustomAnnotator(){
    return CustomAnnotator.class;
  }

  @Override
  public boolean isIncludeAdditionalProperties() {
    return false;
  }

  @Override
  public SourceType getSourceType() {
    return SourceType.JSONSCHEMA;
  }

  @Override
  public AnnotationStyle getAnnotationStyle() {
    return AnnotationStyle.NONE;
  }

  @Override
  public boolean isIncludeRequiredPropertiesConstructor() {
    return false;
  }

}
