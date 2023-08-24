package ma.roudane.commande.service.commande.impl;

import lombok.AllArgsConstructor;
import ma.roudane.commande.dao.ICommandesDao;
import ma.roudane.commande.model.CommandeEntity;
import ma.roudane.commande.service.commande.ICommandeApplication;
import ma.roudane.commande.service.commande.mappers.ICommandeApplicationMapper;
import ma.roudane.commande.service.commande.models.Commande;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CommandeApplicationImpl implements ICommandeApplication {

    private final ICommandesDao commandesDao;
    private final ICommandeApplicationMapper commandeApplicationMapper;
    @Override
    public Commande saveCommande(final Commande commande) {
        CommandeEntity commandeEntity = commandesDao.save(this.commandeApplicationMapper.CommandeAppToEntity(commande));
        return this.commandeApplicationMapper.CommandeEntityToApp(commandeEntity);
    }

    @Override
    public Optional<Commande> getCommande(Integer id) {
        Optional<Commande> commande = commandesDao.findById(id).map(commandeApplicationMapper::CommandeEntityToApp);
        return commande;
    }
}
