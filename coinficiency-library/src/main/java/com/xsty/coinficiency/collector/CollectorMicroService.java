package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candlestick.Candlestick;
import com.xsty.coinficiency.candlestick.CandlestickCollector;
import com.xsty.coinficiency.exchange.Exchange;
import com.xsty.coinficiency.exchange.ExchangeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XST on 30/12/2017.
 */
@RestController
@ConfigurationProperties(prefix = "collector")
@Configuration
public abstract class CollectorMicroService {

    private ExchangeProperties exchange;

    public ExchangeProperties getExchange() {
        return exchange;
    }

    public void setExchange(ExchangeProperties exchange) {
        this.exchange = exchange;
    }

    public abstract CandlestickCollector collector();

    @GetMapping()
    public ResponseEntity<Exchange> exchange() {
        return ResponseEntity.ok(
                exchange
        );
    }

    @GetMapping(path = "/candlesticks/{symbolpair}/{timeframe}")
    public ResponseEntity<Candlestick> candlestick(
            @PathVariable(value = "symbolpair") String symbolpair,
            @PathVariable(value = "timeframe") String timeframe
    ) {
        symbolpair = checkSymbolpair(symbolpair);
        timeframe = checkTimeframe(timeframe);

        return ResponseEntity.ok(
                collector().collectCandlestick(
                        symbolpair,
                        timeframe
                )
        );
    }

    private String checkSymbolpair(String symbolpair) {
        if (this.exchange.getSymbolpairs().contains(symbolpair))
            return symbolpair;

        return this.exchange.getSymbolpairs().get(0);
    }

    private String checkTimeframe(String timeframe) {
        if (this.exchange.getTimeframes().contains(timeframe))
            return timeframe;

        return this.exchange.getTimeframes().get(0);
    }
}
