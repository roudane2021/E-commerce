package ma.roudane.paiement.service.paiement;

import ma.roudane.paiement.service.paiement.models.Paiement;

public interface IPaiementApplication {

    Paiement pagetPaiementID(Integer id);
    Paiement savePaiement(Paiement paiement);
}
