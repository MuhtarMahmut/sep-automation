package com.sep.pojos.prices.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    @JsonProperty("priceId")
    private String priceId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("allowCoupons")
    private boolean allowCoupons;

    @JsonProperty("receipt")
    private Receipt receipt;

}
