package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    void getAllUsersByAuthorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/library/authors/2/users"))
                .andExpect(status().isOk()
                );
    }

    @Test
    @Transactional
    public void testAuthorSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/library/authors/save")
                .content("{ " +
                        "\"firstName\": \"Александр\", " +
                        "\"secondName\":\"Пушкин\"" +
                        "}")
                .contentType("application/json")
        ).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void tesUserSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/library/users/save")
                .content("{ " +
                        "\"firstName\": \"Михаил\", " +
                        "\"secondName\":\"Михайлов\"" +
                        "}")
                .contentType("application/json")
        ).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void tesBookSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/library/books/save")
                .content("{ " +
                        "\"bookTitle\": \"Два Гусара\", " +
                        "\"author\": { \"id\": 2 }" +
                    "}"
                )
                .contentType("application/json")
        ).andExpect(status().isOk());
    }

}
