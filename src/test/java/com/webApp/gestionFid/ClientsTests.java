package com.webApp.gestionFid;

import com.webApp.clientsService.ClientsService;
import com.webApp.model.Clients;
import com.webApp.model.Fidelity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;

@WebFluxTest(ClientsTests.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientsTests {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	private ClientsService clientsService;

	private Clients createClient(){

		Clients client = new Clients();
		client.setCode("09379373939");
		client.setName("Chris koffi");
		client.setCreationdate(new Date());
		client.setAddress("20 avenue de la liberté, 34000");
		client.setEmail("chriskoffi@gmail.com");
		client.setTelephone("0033637917776");
		client.setActive(true);


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
		Clients clients = this.createClient();
	}

}
