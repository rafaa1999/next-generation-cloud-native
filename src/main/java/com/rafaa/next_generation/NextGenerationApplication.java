package com.rafaa.next_generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class NextGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextGenerationApplication.class, args);
	}

}

@RestController
@RequestMapping("/books")
class BookController{

	@GetMapping
	List<Book> getAllBooks(){
		return List.of(
				new Book(1L,"Game of thrones"),
				new Book(2L,"The lord of the ring")
		);
	}

}

record Book(Long id, String title){}