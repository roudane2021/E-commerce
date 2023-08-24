package ma.roudane.paiement.service.paiement.models;

import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paiement {
    private int id;

    private Integer idCommande;

    private Integer montant;

    private Long numeroCarte;
}
