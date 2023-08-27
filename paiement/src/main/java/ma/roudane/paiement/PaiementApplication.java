package ma.roudane.paiement;

import lombok.AllArgsConstructor;
import ma.roudane.paiement.dao.PaiementDao;
import ma.roudane.paiement.model.PaiementEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class PaiementApplication implements CommandLineRunner {


	private final PaiementDao paiementDao;

	public static void main(String[] args) {
		SpringApplication.run(PaiementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PaiementEntity p1 = PaiementEntity.builder().montant(155).idCommande(1).numeroCarte(12l).build();
		PaiementEntity p2 = PaiementEntity.builder().montant(897).idCommande(2).numeroCarte(13l).build();
		PaiementEntity p3 = PaiementEntity.builder().montant(1587).idCommande(3).numeroCarte(14l).build();
		List<PaiementEntity> list = Arrays.asList(p1, p1,  p3);
		paiementDao.saveAllAndFlush(list);
	}
}
