package ma.roudane.produit.service.produit.mapper;


import ma.roudane.produit.model.ProduitEntity;
import ma.roudane.produit.service.produit.models.Produit;
import ma.roudane.produit.web.product.dto.ProduitDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProduitApplicationMapper {

    Produit ProduitEntityToApp(ProduitEntity entity);

    ProduitEntity ProduitAppToEntity(Produit produit);

    ProduitDto ProduitAppToDto(Produit produit);

    Produit ProduitDtoToApp(ProduitDto produitDto);

    //List
    List<Produit> ProduitEntityToAppList(List<ProduitEntity> list);

    List<ProduitEntity> ProduitAppToEntity(List<Produit> list);

    List<ProduitDto> ProduitAppToDtoList(List<Produit> list);

    List<Produit> ProduitDtoToAppList(List<ProduitDto> list);
}
