package com.json2pojo.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "json2pojo.sofascore")
@AllArgsConstructor
@Component
public class SofascoreJsonToPojoConfiguration extends JsonToPojoConfiguration {
}
