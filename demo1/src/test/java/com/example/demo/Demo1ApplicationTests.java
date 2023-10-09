package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Demo1ApplicationTests {


	@Autowired
	private PartsController partsController;
	@Test
	void contextLoads() {
		assertTrue(partsController != null);
	}

}
