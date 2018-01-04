package com.xsty.coinficiency.candlestick;

/**
 * Created by XST on 29/12/2017.
 */
public interface CandlestickCollector {
    Candlestick collectCandlestick(String symbolPair, String timeFrame);
}
