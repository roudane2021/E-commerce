package ma.roudane.produit.dao;

import ma.roudane.produit.model.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitDao extends JpaRepository<ProduitEntity, Integer> {
}
