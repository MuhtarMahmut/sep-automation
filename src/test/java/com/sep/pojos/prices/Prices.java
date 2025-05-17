package com.sep.pojos.prices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sep.pojos.prices.data.PricesData;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prices {

    @JsonProperty("data")
    private PricesData data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;
}