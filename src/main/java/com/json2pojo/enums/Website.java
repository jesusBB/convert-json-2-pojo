package com.json2pojo.enums;

public enum Website {
  SOFASCORE,
  FOTMOB;

  public static Website getWebsiteFromString(String websiteString) {
    for (Website websiteEnumValue : Website.values()) {
      if (websiteEnumValue.name().equalsIgnoreCase(websiteString)) {
        return websiteEnumValue;
      }
    }
    throw new IllegalArgumentException("Invalid websiteString: " + websiteString);
  }
}
