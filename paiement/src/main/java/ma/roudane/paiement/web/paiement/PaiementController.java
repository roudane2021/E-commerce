package ma.roudane.paiement.web.paiement;

import lombok.AllArgsConstructor;
import ma.roudane.paiement.dao.PaiementDao;
import ma.roudane.paiement.model.PaiementEntity;
import ma.roudane.paiement.service.paiement.IPaiementApplication;
import ma.roudane.paiement.service.paiement.mapper.IPaiementApplicationMapper;
import ma.roudane.paiement.web.exceptions.PaiementExistantException;
import ma.roudane.paiement.web.exceptions.PaiementImpossibleException;
import ma.roudane.paiement.web.paiement.dto.PaiementDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/paiement")
@AllArgsConstructor
public class PaiementController {


    private final IPaiementApplication paiementApplication;
    private final IPaiementApplicationMapper paiementApplicationMapper;

    @PostMapping()
    public ResponseEntity<PaiementDto> payerUneCommande(@RequestBody final PaiementDto paiement){

              //Vérifions s'il y a déjà un paiement enregistré pour cette commande
        PaiementDto paiementExistant = paiementApplicationMapper.PaiementAppToDto(paiementApplication.pagetPaiementID(paiement.getIdCommande()));
        if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");

        //Enregistrer le paiement
        PaiementDto nouveauPaiement = paiementApplicationMapper.PaiementAppToDto(paiementApplication.savePaiement(paiementApplicationMapper.PaiementDtoToApp(paiement)));


        if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");



        //TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté

        return new ResponseEntity<PaiementDto>(nouveauPaiement, HttpStatus.CREATED);

    }




}
