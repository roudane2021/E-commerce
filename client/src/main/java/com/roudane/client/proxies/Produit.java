package com.roudane.client.proxies;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Produit {
    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;
}
