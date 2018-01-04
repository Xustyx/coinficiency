package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candlestick.Candlestick;
import com.xsty.coinficiency.candlestick.CandlestickCollector;
import com.xsty.coinficiency.exchange.Exchange;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XST on 31/12/2017.
 */
@Component
public class BinanceCandlestickCollector implements CandlestickCollector {

    public static final String DEFAULT_ENDPOINT_PATTERN = "https://api.binance.com/api/v1/klines?symbol={symbolpair}&interval={timeframe}";
    private static final String TIMEFRAME_PLACEHOLDER = "timeframe";
    private static final String SYMBOLPAIR_PLACEHOLDER = "symbolpair";

    private String endpoint;
    private RestTemplate restTemplate;

    public BinanceCandlestickCollector() {
        this(new RestTemplate(), DEFAULT_ENDPOINT_PATTERN);
    }

    public BinanceCandlestickCollector(String endpoint) {
        this(new RestTemplate(), endpoint);
    }

    public BinanceCandlestickCollector(RestTemplate restTemplate, String endpoint) {
        this.endpoint = endpoint;
        this.restTemplate = restTemplate;
    }

    @Override
    public Candlestick collectCandlestick(String symbolPair, String timeFrame) {
        List<List<Object>> binanceCandlestick;
        try {
            binanceCandlestick = restTemplate.getForObject(endpoint,List.class,params(symbolPair, timeFrame));
        } catch (Exception e){
            e.printStackTrace();
            binanceCandlestick = new ArrayList<List<Object>>();
        }

        return new BinanceCandlestickAdapter(binanceCandlestick);
    }

    private Map<String,String> params(String symbolPair, String timeFrame) {
        Map<String,String> params = new HashMap<>();
        params.put(SYMBOLPAIR_PLACEHOLDER,symbolPair);
        params.put(TIMEFRAME_PLACEHOLDER, timeFrame);
        return params;
    }
}
