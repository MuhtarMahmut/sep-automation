package com.sep.pojos.prices.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receipt {

    @JsonProperty("paymentType")
    private String paymentType;

    @JsonProperty("paymentSummary")
    private PaymentSummary paymentSummary;

    @JsonProperty("installmentSummary")
    private InstallmentSummary installmentSummary;

}