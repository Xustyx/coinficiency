package com.xsty.coinficiency.exchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by XST on 29/12/2017.
 */
@Repository
public interface ExchangeRepository extends JpaRepository<WebExchange,Long> {
    WebExchange findByName(String name);
}
