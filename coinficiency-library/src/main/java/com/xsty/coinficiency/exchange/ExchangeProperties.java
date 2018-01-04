package com.xsty.coinficiency.exchange;

import java.util.List;

/**
 * Created by XST on 31/12/2017.
 */
public class ExchangeProperties implements Exchange {
    private String name;
    private List<String> symbolpairs;
    private List<String> timeframes;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getSymbolpairs() {
        return symbolpairs;
    }

    public void setSymbolpairs(List<String> symbolpairs) {
        this.symbolpairs = symbolpairs;
    }

    @Override
    public List<String> getTimeframes() {
        return timeframes;
    }

    public void setTimeframes(List<String> timeframes) {
        this.timeframes = timeframes;
    }
}
