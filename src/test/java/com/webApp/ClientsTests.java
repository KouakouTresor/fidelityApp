package com.webApp;

import com.webApp.clientsService.ClientsService;
import com.webApp.controller.ClientsController;
import com.webApp.model.Clients;
import com.webApp.model.Fidelity;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


import java.util.Date;


@WebFluxTest(ClientsTests.class)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTests {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	ClientsService clientsService;


	public Clients createClients() {
		Clients client = new Clients();
		client.setId("123");
		client.setCode("09379373939");
		client.setName("Chris koffi");
		client.setAddress("20 avenue de la liberté");
		client.setVille("3400, Montpellier");
		client.setPhone("0033637917776");
		client.setEmail("chriskoffi@gmail.com");
		client.setActive(true);
		client.setCreationdate(new Date());

		Fidelity fidelity = new Fidelity();
		fidelity.setPoints(300);
		fidelity.setLastshop("2022-02-18");

		client.setFidelity(fidelity);
		return client;
	}
		@Test
		@Order(1)
		public void testInsertClient() throws Exception
		{
			Clients client = this.createClients();
			Mono<Clients> clientMono = Mono.just(client);

			clientsService.SaveClient(client).thenReturn(clientMono);
			webTestClient.post()
					.uri("/api/clients/insert")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.body(clientMono,Clients.class )
					.exchange()
					.expectStatus().isCreated();

		}


}
