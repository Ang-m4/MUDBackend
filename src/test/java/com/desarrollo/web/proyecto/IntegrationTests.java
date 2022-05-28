package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;

import com.desarrollo.web.proyecto.Model.DecorativeItem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTests {

	@LocalServerPort
	private int port;

	@Autowired
	DecorativeItemRepository decorativeItemRepository;

	@Autowired
	TestRestTemplate rest;

	@BeforeEach
	void init() {

		this.decorativeItemRepository.save(new DecorativeItem("Deco test A"));
		this.decorativeItemRepository.save(new DecorativeItem("Deco test B"));
		this.decorativeItemRepository.save(new DecorativeItem("Deco test C"));

	}

	@Test
	void getTest() {

		DecorativeItem decoItem = this.rest.getForObject("http://localhost:" + port + "/decoItem/3/get",
				DecorativeItem.class);
		assertEquals("Deco test C", decoItem.getName());

	}

	@Test
	void createTest() {

		DecorativeItem decoItem = this.rest.postForObject(
				"http://localhost:" + port + "/decoItem/save",
				new DecorativeItem("new Item"),
				DecorativeItem.class);

		assertEquals("new Item", decoItem.getName());

	}

	@Test
	void editTest() {

		Long id = 2l;

		DecorativeItem editDecoItem = new DecorativeItem("Deco Test B edited");
		editDecoItem.setId(2l);

		this.rest.postForObject(
				"http://localhost:" + port + "/decoItem/save",
				editDecoItem,
				DecorativeItem.class);

		DecorativeItem decoItem = this.rest.getForObject("http://localhost:" + port + "/decoItem/" + id + "/get",
				DecorativeItem.class);

		assertEquals("Deco Test B edited", decoItem.getName());

	}

	@Test
	void deleteTest() {

		String message = this.rest.getForObject(
				"http://localhost:" + port + "/decoItem/1/delete", String.class);

		assertEquals("item deleted", message);

	}


	




}
