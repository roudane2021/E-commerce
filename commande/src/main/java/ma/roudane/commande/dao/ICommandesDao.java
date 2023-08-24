package ma.roudane.commande.dao;

import ma.roudane.commande.model.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandesDao extends JpaRepository<CommandeEntity, Integer> {
        }