package com.rafaa.next_generation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

class NextGenerationApplicationTests {

	public static void main(String[] args) {
		SpringApplication.from(NextGenerationApplicationTests::main)
				.with(TestEnvironmentConfiguration.class)
				.run(args);
	}

}
