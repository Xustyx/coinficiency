package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candle.Candle;
import com.xsty.coinficiency.candlestick.Candlestick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XST on 31/12/2017.
 */
class BinanceCandlestickAdapter implements Candlestick {

    private List<Candle> candles;

    public BinanceCandlestickAdapter(List<List<Object>> binanceCandlestick) {
        this.setUpCandles(binanceCandlestick);
    }

    @Override
    public List<Candle> getCandles() {
        return candles;
    }

    private void setUpCandles(List<List<Object>> binanceCandlestick){
        List<Candle> candles = new ArrayList<>();

        for(List<Object> binanceCandle: binanceCandlestick){
            candles.add(
                    new BinanceCandleAdapter(binanceCandle)
            );
        }

        this.candles = candles;
    }
}
