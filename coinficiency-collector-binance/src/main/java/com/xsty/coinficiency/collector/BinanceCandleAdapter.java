package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candle.Candle;

import java.util.List;

/**
 * Created by XST on 31/12/2017.
 */
class BinanceCandleAdapter implements Candle {
    private long timestamp;
    private double open;
    private double close;
    private double high;
    private double low;

    public BinanceCandleAdapter(List<Object> binanceCandle) {
        this.setUpCandle(binanceCandle);
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public double getOpen() {
        return open;
    }

    @Override
    public double getClose() {
        return close;
    }

    @Override
    public double getHigh() {
        return high;
    }

    @Override
    public double getLow() {
        return low;
    }

    private void setUpCandle(List<Object> binanceCandle){
        this.timestamp = checkLongValueByPos(binanceCandle, 0);
        this.open = checkDoubleValueByPos(binanceCandle, 1);
        this.high = checkDoubleValueByPos(binanceCandle, 2);
        this.low = checkDoubleValueByPos(binanceCandle, 3);
        this.close = checkDoubleValueByPos(binanceCandle, 4);
    }

    private long checkLongValueByPos(List<Object> bitfinexCandle, int pos){
        Long value;
        try{
            value = new Long(bitfinexCandle.get(pos).toString());
        }catch (Exception e){
            e.printStackTrace();
            value = 0L;
        }
        return value;
    }

    private double checkDoubleValueByPos(List<Object> bitfinexCandle, int pos){
        Double value;
        try{
            value = new Double(bitfinexCandle.get(pos).toString());
        }catch (Exception e){
            e.printStackTrace();
            value = 0.0;
        }
        return value;
    }
}
