package ma.roudane.produit.service.produit;

import ma.roudane.produit.service.produit.models.Produit;

import java.util.List;
import java.util.Optional;

public interface IprouduitApplication {

    List<Produit> produits();

    Optional<Produit> getProduitByID(Integer id);
}
