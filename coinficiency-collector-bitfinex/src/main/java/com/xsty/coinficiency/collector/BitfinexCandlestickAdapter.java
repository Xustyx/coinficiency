package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candle.Candle;
import com.xsty.coinficiency.candlestick.Candlestick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XST on 30/12/2017.
 */
class BitfinexCandlestickAdapter implements Candlestick {

    private List<Candle> candles;

    public BitfinexCandlestickAdapter(List<List<Object>> bitfinexCandlestick){
        this.setUpCandles(bitfinexCandlestick);
    }

    @Override
    public List<Candle> getCandles() {
        return candles;
    }

    private void setUpCandles(List<List<Object>> bitfinexCandlestick){
        List<Candle> candles = new ArrayList<>();

        for(List<Object> bitfinexCandle: bitfinexCandlestick){
            candles.add(
                    new BitfinexCandleAdapter(bitfinexCandle)
            );
        }

        this.candles = candles;
    }
}
