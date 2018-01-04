package com.xsty.coinficiency.collector;


import com.xsty.coinficiency.candlestick.Candlestick;
import com.xsty.coinficiency.candlestick.CandlestickCollector;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XST on 29/12/2017.
 */
@Component
public class BitfinexCandlestickCollector implements CandlestickCollector {

    private static final String DEFAULT_ENDPOINT_PATTERN = "https://api.bitfinex.com/v2/candles/trade:{timeframe}:t{symbolpair}/hist?limit=1000";
    private static final String TIMEFRAME_PLACEHOLDER = "timeframe";
    private static final String SYMBOLPAIR_PLACEHOLDER = "symbolpair";

    private String endpointPattern;
    private RestTemplate restTemplate;

    public BitfinexCandlestickCollector() {
        this(new RestTemplate(), DEFAULT_ENDPOINT_PATTERN);
    }

    public BitfinexCandlestickCollector(String endpointPattern) {
        this(new RestTemplate(), endpointPattern);
    }

    public BitfinexCandlestickCollector(RestTemplate restTemplate, String endpointPattern) {
        this.endpointPattern = endpointPattern;
        this.restTemplate = restTemplate;
    }

    @Override
    public Candlestick collectCandlestick(String symbolPair, String timeFrame) {
        List<List<Object>> bitfinexCandlestick;
        try {
            bitfinexCandlestick = restTemplate.getForObject(endpointPattern, List.class, params(symbolPair, timeFrame));
        } catch (Exception e) {
            e.printStackTrace();
            bitfinexCandlestick = new ArrayList<List<Object>>();
        }
        return new BitfinexCandlestickAdapter(bitfinexCandlestick);
    }

    private Map<String, String> params(String symbolPair, String timeFrame) {
        Map<String, String> params = new HashMap<>();
        params.put(TIMEFRAME_PLACEHOLDER, timeFrame);
        params.put(SYMBOLPAIR_PLACEHOLDER, symbolPair);
        return params;
    }
}
