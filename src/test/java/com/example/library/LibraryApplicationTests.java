package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllBooksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/library/users/1/books"))
                .andExpect(status().isOk()
                );
    }

    @Test
    void getAllBooksFromAuthorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/library/authors/1/books"))
                .andExpect(status().isOk()
                );
    }

}
