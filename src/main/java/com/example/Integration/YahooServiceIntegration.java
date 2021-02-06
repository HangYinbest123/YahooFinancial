package com.example.Integration;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.IOException;

public class YahooServiceIntegration {
    private static final String QUOTES_QUERY_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-quotes";
    private static final String SYMBOL = "symbols";
    private static final String REGION = "region";

    public ResponseEntity<String> getQuoteSpring(String symbol) throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "95d6acc078msh9ba6639d0df4657p1a2bacjsna8d880743664");
        headers.add("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(QUOTES_QUERY_URL)
                .queryParam(SYMBOL, symbol.toUpperCase()).queryParam(REGION, "US");
        return restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, String.class);
    }


}
