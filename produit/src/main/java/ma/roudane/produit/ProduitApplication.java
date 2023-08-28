package ma.roudane.produit;

import lombok.AllArgsConstructor;
import ma.roudane.produit.dao.IProduitDao;
import ma.roudane.produit.model.ProduitEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class ProduitApplication implements CommandLineRunner {

	private final IProduitDao ProduitDao;

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ProduitEntity p1 = ProduitEntity.builder().description("Television").prix(125d).titre("Television").build();
		ProduitEntity p2 = ProduitEntity.builder().description("Plaque de cuisson électrique").prix(999d).titre("Plaque de cuisson électrique").build();
		ProduitEntity p3 = ProduitEntity.builder().description("Bouilloire électrique").prix(1999d).titre("Bouilloire électrique").build();
		List<ProduitEntity> list  = Arrays.asList(p1, p2, p3);
		this.ProduitDao.saveAll(list);


	}
}
