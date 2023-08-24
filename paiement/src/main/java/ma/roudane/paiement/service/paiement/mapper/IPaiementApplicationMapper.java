package ma.roudane.paiement.service.paiement.mapper;


import ma.roudane.paiement.model.PaiementEntity;
import ma.roudane.paiement.service.paiement.models.Paiement;
import ma.roudane.paiement.web.paiement.dto.PaiementDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPaiementApplicationMapper {

    Paiement PaiementEntityToApp(PaiementEntity paiementEntity);

    PaiementEntity PaiementAppToEntity(Paiement paiement);

    PaiementDto PaiementAppToDto(Paiement paiement);

    Paiement PaiementDtoToApp(PaiementDto paiementDto);

    //List
    List<Paiement> PaiementEntityToAppList(List<PaiementEntity> list);

    List<PaiementEntity> PaiementAppToEntity(List<Paiement> list);

    List<PaiementDto> PaiementAppToDtoList(List<Paiement> list);

    List<Paiement> PaiementDtoToAppList(List<PaiementDto> list);
}
