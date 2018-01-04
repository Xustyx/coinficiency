package com.xsty.coinficiency.exchange;

import com.xsty.coinficiency.candlestick.CandlestickCollector;

import javax.persistence.Entity;
import java.util.Set;

/**
 * Created by XST on 29/12/2017.
 */
@Entity
public class WebExchange implements Exchange {
    private Long id;

    private String name;
    private Set<SymbolPair> symbolPairs;
    private Set<String> timeFrames;


    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<SymbolPair> getSymbolPairs() {
        return symbolPairs;
    }

    @Override
    public Set<String> getTimeFrames() {
        return timeFrames;
    }

    @Override
    public CandlestickCollector getCandlestickCollector() {
        return null;
    }
}
