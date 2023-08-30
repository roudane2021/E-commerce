package com.roudane.gatewayserver;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class GatewayServerApplication {

	private final TokenRelayGatewayFilterFactory filterFactory;

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("commandeModule", r -> r
						.path("/commandes/**")
						.filters(f -> f.filter(filterFactory.apply()))
						.uri("lb://microservice-commandes")
				)
				.route("produitsModule", r -> r
						.path("/produits/**")
						.filters(f -> f.filter(filterFactory.apply()))
						.uri("lb://microservice-produits")
				)
				.build();
	}

	@Bean
	public SecurityWebFilterChain springSecurity(ServerHttpSecurity http) {

		http.authorizeExchange()
				.pathMatchers("/actuator/**")
				.permitAll()
				.and()
				.authorizeExchange()
				.anyExchange()
				.authenticated()
				.and()
				.oauth2Login();

		return http.build();

	}


}
