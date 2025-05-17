package com.sep.pojos.program;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sep.pojos.program.data.ProgramData;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Program {

    @JsonProperty("data")
    private ProgramData data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;
}