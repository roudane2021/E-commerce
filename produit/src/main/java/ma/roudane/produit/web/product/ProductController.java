package ma.roudane.produit.web.product;


import lombok.AllArgsConstructor;
import ma.roudane.produit.model.ProduitEntity;
import ma.roudane.produit.service.produit.IprouduitApplication;
import ma.roudane.produit.service.produit.mapper.IProduitApplicationMapper;
import ma.roudane.produit.service.utils.AppConfigProperties;
import ma.roudane.produit.web.exceptions.ProductNotFoundException;
import ma.roudane.produit.web.product.dto.ProduitDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "produits")
@AllArgsConstructor
public class ProductController {


    private final IProduitApplicationMapper mapper;
    private final IprouduitApplication application;
    private final AppConfigProperties appConfigProperties;

    // Affiche la liste de tous les produits disponibles
    @GetMapping()
    public List<ProduitDto> listeDesProduits(){

        List<ProduitDto> products = mapper.ProduitAppToDtoList(application.produits());

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        List<ProduitDto> listLimit = products.subList(0, this.appConfigProperties.getMaxProduits());

        return listLimit;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/{id}")
    public Optional<ProduitDto> recupererUnProduit(@PathVariable int id) {

        Optional<ProduitDto> product = application.getProduitByID(id).map(mapper::ProduitAppToDto);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }
}