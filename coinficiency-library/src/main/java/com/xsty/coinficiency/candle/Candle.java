package com.xsty.coinficiency.candle;

/**
 * Created by XST on 29/12/2017.
 */
public interface Candle {
    long getTimestamp();

    double getOpen();

    double getClose();

    double getHigh();

    double getLow();
}
