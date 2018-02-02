package it.contrader.sprint4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello (Map<String, Object> model) {
        return "hello";
    }

    @RequestMapping(value="/prova",method=RequestMethod.GET)


    public String prova(){

        RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject("https://min-api.cryptocompare.com/data/price?fsym=EUR&tsyms=BTC,ETH,LIT", String.class);
        return quote;
    }

}