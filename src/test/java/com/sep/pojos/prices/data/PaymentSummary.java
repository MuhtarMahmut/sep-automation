package com.sep.pojos.prices.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSummary {
    @JsonProperty("basePrice")
    private int basePrice;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("oneTimeDiscount")
    private int oneTimeDiscount;

    @JsonProperty("couponDiscount")
    private int couponDiscount;

    @JsonProperty("subTotal")
    private int subTotal;

    @JsonProperty("fee")
    private double fee;

    @JsonProperty("total")
    private double total;

}
