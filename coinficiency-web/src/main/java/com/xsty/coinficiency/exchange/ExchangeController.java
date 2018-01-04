package com.xsty.coinficiency.exchange;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by XST on 29/12/2017.
 */
@RestController
@RequestMapping(path = "/exchange")
public class ExchangeController {

    private ExchangeRepository exchangeRepository;

    @Autowired
    public void setExchangeRepository(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    //Get
    @GetMapping(path = "/{id}")
    public WebExchange readExchange(@PathVariable Long id){
        return this.exchangeRepository.findOne(id);
    }

    @GetMapping(path = "/{name}")
    public WebExchange readExchangeByName(@PathVariable String name){
        return this.exchangeRepository.findByName(name);
    }

    @GetMapping
    public List<WebExchange> readExchanges(){
        return this.exchangeRepository.findAll();
    }

    //Post
    @PostMapping
    public WebExchange createExchange(WebExchange webExchange){
        return this.exchangeRepository.save(webExchange);
    }

    //Delete
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void removeExchange(@PathVariable Long id){
        this.exchangeRepository.delete(id);
    }
}
