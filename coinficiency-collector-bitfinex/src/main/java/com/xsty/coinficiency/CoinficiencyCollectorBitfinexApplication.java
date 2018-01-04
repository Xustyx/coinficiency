package com.xsty.coinficiency;

import com.xsty.coinficiency.candlestick.CandlestickCollector;
import com.xsty.coinficiency.collector.CollectorMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinficiencyCollectorBitfinexApplication extends CollectorMicroService {

    public static void main(String[] args) {
        SpringApplication.run(CoinficiencyCollectorBitfinexApplication.class, args);
    }

    private CandlestickCollector candlestickCollector;

    @Autowired
    public void setCandlestickCollector(CandlestickCollector candlestickCollector) {
        this.candlestickCollector = candlestickCollector;
    }

    @Override
    public CandlestickCollector collector() {
        return candlestickCollector;
    }
}
