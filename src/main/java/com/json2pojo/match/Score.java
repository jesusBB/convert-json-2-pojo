
package com.json2pojo.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "winner",
    "duration",
    "fullTime",
    "halfTime"
})
public class Score {

    @JsonProperty("winner")
    public Object winner;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("fullTime")
    public FullTime fullTime;
    @JsonProperty("halfTime")
    public HalfTime halfTime;

}
