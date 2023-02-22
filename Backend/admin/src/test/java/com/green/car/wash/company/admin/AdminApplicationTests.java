package com.green.car.wash.company.admin;
import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.green.car.wash.company.admin.model.WashPacks;
import com.green.car.wash.company.admin.repository.WashPackRepo;
import com.green.car.wash.company.admin.service.WashPackService;

@SpringBootTest
public class AdminApplicationTests {
	@MockBean
	WashPackRepo washrepo;
	@Autowired
	WashPackService service;

	@Test
	public void allWPTest() {
		when(washrepo.findAll()).thenReturn(Stream.of(new WashPacks("123","clean",300,"clean wash")
				).collect(Collectors.toList()));
		assertEquals("This should return all the wash packs available and count them",2,service.findallWP().size());
	}
	}


