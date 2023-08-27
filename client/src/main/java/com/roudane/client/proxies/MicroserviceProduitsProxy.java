package com.roudane.client.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${webservice.produit.name}", url = "${webservice.produit.url}", decode404 = true)
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "produits")
    List<Produit> litsProduit();

    @GetMapping(value = "produits/{id}")
    Produit produitByID(@PathVariable int id);
}
