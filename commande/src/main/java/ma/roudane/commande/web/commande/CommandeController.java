package ma.roudane.commande.web.commande;

import lombok.AllArgsConstructor;
import ma.roudane.commande.dao.ICommandesDao;
import ma.roudane.commande.model.CommandeEntity;
import ma.roudane.commande.service.commande.ICommandeApplication;
import ma.roudane.commande.service.commande.mappers.ICommandeApplicationMapper;
import ma.roudane.commande.service.commande.models.Commande;
import ma.roudane.commande.web.commande.models.CommandeDto;
import ma.roudane.commande.web.exceptions.CommandeNotFoundException;
import ma.roudane.commande.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/commandes")
@AllArgsConstructor
public class CommandeController {



    private final ICommandeApplication commandeApplication;
    private final ICommandeApplicationMapper commandeApplicationMapper;

    @PostMapping()
    public ResponseEntity<CommandeDto> ajouterCommande(@RequestBody final CommandeDto commandeDto) {
        Commande commandeNew = commandeApplication.saveCommande(commandeApplicationMapper.CommandeDtoToApp(commandeDto));

        if (commandeNew == null)
            throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<CommandeDto>(commandeApplicationMapper.CommandeAppToDto(commandeNew), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public Optional<CommandeDto> recupererUneCommande(@PathVariable int id) {

        Optional<CommandeDto> commande = commandeApplication.getCommande(id).map(commandeApplicationMapper::CommandeAppToDto);

        if (!commande.isPresent()) {
            throw new CommandeNotFoundException("Cette commande n'existe pas");
        }

        return commande;
    }
}
