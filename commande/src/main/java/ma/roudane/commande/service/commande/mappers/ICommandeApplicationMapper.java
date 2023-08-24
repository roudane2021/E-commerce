package ma.roudane.commande.service.commande.mappers;

import ma.roudane.commande.model.CommandeEntity;
import ma.roudane.commande.service.commande.models.Commande;
import ma.roudane.commande.web.commande.models.CommandeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommandeApplicationMapper {

    Commande CommandeEntityToApp(CommandeEntity commandeEntity);

    CommandeEntity CommandeAppToEntity(Commande commande);

    CommandeDto CommandeAppToDto(Commande commande);

    Commande CommandeDtoToApp(CommandeDto commandeDto);

    //List
    List<Commande> CommandeEntityToAppList(List<CommandeEntity> list);

    List<CommandeEntity> CommandeAppToEntity(List<Commande> commande);

    List<CommandeDto> CommandeAppToDtoList(List<Commande> commande);

    List<Commande> CommandeDtoToAppList(List<CommandeDto> commandeDto);
}
