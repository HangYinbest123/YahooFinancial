package com.example.Integration;

import com.example.Integration.models.QuoteResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

public class YahooServiceIntegrationTest {
    YahooServiceIntegration yahooServiceIntegration = new YahooServiceIntegration();

    @Test
    public void getQuoteSpring() throws IOException {
        ResponseEntity<String> responseEntity = yahooServiceIntegration.getQuoteSpring("AMD");
        String body = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(body);
        List<QuoteResponse> result = new ArrayList<>();
        if(node.has("quoteResponse") && node.get("quoteResponse").has("result")) {
            node = node.get("quoteResponse").get("result");

            for(int i = 0; i < node.size(); i++) {
                QuoteResponse quoteResponse = objectMapper.readValue(node.get(i).toString(), QuoteResponse.class);
                result.add(quoteResponse);
            }
        } else {
            throw new IOException("Invalid response");
        }
    }
}