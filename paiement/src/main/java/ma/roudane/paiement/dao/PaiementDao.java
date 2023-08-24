package ma.roudane.paiement.dao;

import ma.roudane.paiement.model.PaiementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementDao extends JpaRepository<PaiementEntity, Integer> {
    PaiementEntity findByidCommande(int idCommande);
}
