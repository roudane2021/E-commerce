package com.roudane.client.controller;


import com.roudane.client.proxies.MicroserviceProduitsProxy;
import com.roudane.client.proxies.Produit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final MicroserviceProduitsProxy produitsProxy;

    @GetMapping()
    public String accueil(){

        return  "Welcome To Web Site";
    }

    @GetMapping("/produits")
    public List<Produit> produits(){

        return  this.produitsProxy.litsProduit();
    }
    @GetMapping("/produits/{id}")
    public Produit produit(@PathVariable int id){

        return  this.produitsProxy.produitByID(id);
    }
}
