package com.xsty.coinficiency.exchange;

import java.util.List;

/**
 * Created by XST on 30/12/2017.
 */
public interface Exchange {
    String getName();

    List<String> getSymbolpairs();

    List<String> getTimeframes();
}
