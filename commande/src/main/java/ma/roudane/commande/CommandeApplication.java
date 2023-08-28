package ma.roudane.commande;

import lombok.AllArgsConstructor;
import ma.roudane.commande.dao.ICommandesDao;
import ma.roudane.commande.model.CommandeEntity;
import ma.roudane.commande.service.commande.models.Commande;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class CommandeApplication  implements CommandLineRunner {

	private final ICommandesDao commandesDao;

	public static void main(String[] args) {
		SpringApplication.run(CommandeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CommandeEntity commande1 = CommandeEntity.builder().dateCommande(LocalDateTime.now()
				                                 .minusMonths(15)).commandePayee(false).productId(1).build();
		CommandeEntity commande2 = CommandeEntity.builder().dateCommande(LocalDateTime.now()
				.minusMonths(2)).commandePayee(false).productId(2).build();
		CommandeEntity commande3 = CommandeEntity.builder().dateCommande(LocalDateTime.now()
				.minusMonths(5)).commandePayee(false).productId(3).build();
		List<CommandeEntity> commandeEntities = Arrays.asList(commande1, commande2, commande3);
		List<CommandeEntity> list = commandesDao.findAll();

	}
}
