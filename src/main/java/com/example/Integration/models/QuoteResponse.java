package com.example.Integration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {
    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("postMarketPrice")
    String postMarketPrice;
}
