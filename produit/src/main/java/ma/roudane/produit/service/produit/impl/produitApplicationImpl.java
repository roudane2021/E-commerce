package ma.roudane.produit.service.produit.impl;

import lombok.AllArgsConstructor;
import ma.roudane.produit.dao.IProduitDao;
import ma.roudane.produit.service.produit.IprouduitApplication;
import ma.roudane.produit.service.produit.mapper.IProduitApplicationMapper;
import ma.roudane.produit.service.produit.models.Produit;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class produitApplicationImpl  implements IprouduitApplication {

    private final IProduitDao productDao;
    private final IProduitApplicationMapper mapper;
    @Override
    public List<Produit> produits() {
        return mapper.ProduitEntityToAppList(productDao.findAll());
    }

    @Override
    public Optional<Produit> getProduitByID(Integer id) {
        return productDao.findById(id).map(mapper::ProduitEntityToApp);
    }
}
