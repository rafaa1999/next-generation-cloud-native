package com.rafaa.next_generation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
       var book = new Book(1L,"Game of thrones");
       var jsonContent = json.write(book);
       assertThat(jsonContent).extractingJsonPathNumberValue("@.id")
               .isEqualTo(book.id().intValue());
       assertThat(jsonContent).extractingJsonPathStringValue("@.title")
               .isEqualTo(book.title());
    }

    @Test
    void testDeserialize() throws Exception {
        var book = """
                    {
                        "id":1,
                        "title":"Game of thrones"
                    }
                """;
        assertThat(json.parse(book))
                .usingRecursiveComparison()
                .isEqualTo(new Book(1L,"Game of thrones"));
    }

}
