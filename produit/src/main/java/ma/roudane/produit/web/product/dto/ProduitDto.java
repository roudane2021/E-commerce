package ma.roudane.produit.web.product.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class ProduitDto {
    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;
}
