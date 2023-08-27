package ma.roudane.produit.service.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("configs")
@Data
@RefreshScope
public class AppConfigProperties {

    private int maxProduits;
}
