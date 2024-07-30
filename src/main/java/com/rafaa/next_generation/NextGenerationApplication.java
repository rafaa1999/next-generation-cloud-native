package com.rafaa.next_generation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class NextGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextGenerationApplication.class, args);
	}

}

@RestController
@RequestMapping("/books")
class BookController{

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@GetMapping
	List<Book> getBooks() {
		log.info("Retrieving all books");
		return null;
	}

	@GetMapping("{id}")
	Optional<Book> getBookById(@PathVariable Long id) {
		log.info("Retrieving book with id: {}", id);
		return null;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Book addBook(@RequestBody Book book) {
		log.info("Adding new book: {}", book.title());
		return null;
	}

}

record Book(@Id Long id, String title){}

interface 	BookRepository extends ListCrudRepository<Book, Long>{}