package com.xsty.coinficiency.collector;

import com.xsty.coinficiency.candle.Candle;

import java.util.List;

/**
 * Created by XST on 29/12/2017.
 */
class BitfinexCandleAdapter implements Candle {
    private long timestamp;
    private double open;
    private double close;
    private double high;
    private double low;

    public BitfinexCandleAdapter(List<Object> bitfinexCandle) {
        this.setUpCandle(bitfinexCandle);
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

    private void setUpCandle(List<Object> bitfinexCandle){
        this.timestamp = checkLongValueByPos(bitfinexCandle, 0);
        this.open = checkDoubleValueByPos(bitfinexCandle, 1);
        this.close = checkDoubleValueByPos(bitfinexCandle, 2);
        this.high = checkDoubleValueByPos(bitfinexCandle, 3);
        this.low = checkDoubleValueByPos(bitfinexCandle, 4);
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
