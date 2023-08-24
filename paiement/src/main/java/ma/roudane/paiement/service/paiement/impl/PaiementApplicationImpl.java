package ma.roudane.paiement.service.paiement.impl;

import lombok.AllArgsConstructor;
import ma.roudane.paiement.dao.PaiementDao;
import ma.roudane.paiement.service.paiement.IPaiementApplication;
import ma.roudane.paiement.service.paiement.mapper.IPaiementApplicationMapper;
import ma.roudane.paiement.service.paiement.models.Paiement;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PaiementApplicationImpl implements IPaiementApplication {

    private final  PaiementDao paiementDao;
    private final IPaiementApplicationMapper paiementApplicationMapper;


    @Override
    public Paiement pagetPaiementID(Integer id) {
      final  Paiement paiement = paiementApplicationMapper.PaiementEntityToApp(paiementDao.findByidCommande(id));
        return paiement;
    }

    @Override
    public Paiement savePaiement(Paiement paiement) {

        return paiementApplicationMapper.PaiementEntityToApp(paiementDao.save(paiementApplicationMapper.PaiementAppToEntity(paiement)));
    }
}
