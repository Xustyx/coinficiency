package com.xsty.coinficiency;

import com.xsty.coinficiency.candlestick.CandlestickCollector;
import com.xsty.coinficiency.collector.BinanceCandlestickCollector;
import com.xsty.coinficiency.collector.CollectorMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinficiencyCollectorBinanceApplication extends CollectorMicroService{

	public static void main(String[] args) {
		SpringApplication.run(CoinficiencyCollectorBinanceApplication.class, args);
	}

	private BinanceCandlestickCollector binanceCandlestickCollector;

	@Autowired
	public void setBinanceCandlestickCollector(BinanceCandlestickCollector binanceCandlestickCollector) {
		this.binanceCandlestickCollector = binanceCandlestickCollector;
	}

	@Override
	public CandlestickCollector collector() {
		return binanceCandlestickCollector;
	}
}
