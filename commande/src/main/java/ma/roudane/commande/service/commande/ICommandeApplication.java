package ma.roudane.commande.service.commande;

import ma.roudane.commande.service.commande.models.Commande;

import java.util.Optional;

public interface ICommandeApplication {

    Commande saveCommande(Commande commande);
    Optional<Commande> getCommande(Integer id);
}
