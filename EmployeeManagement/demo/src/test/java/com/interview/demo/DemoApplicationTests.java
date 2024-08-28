package com.interview.demo;

import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@BeforeAll
	static void beforeAllTests() {
		System.out.println("Before all tests");
	}

	@Test
	void testAddition() {

	}


	@AfterAll
	static void afterAllTests() {
		System.out.println("After all tests");
	}
}
