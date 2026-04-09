package com.to_do_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.to_do_list.entity.ToDo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ToDoListApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testCreateTodoSuccess() throws Exception {

		var todo = new ToDo("todo 1", "desc todo 1", false, 1);

		mockMvc.perform(post("/todos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isOk()) // ou isCreated(), depende do seu controller
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value(todo.getName()))
                .andExpect(jsonPath("$[0].description").value(todo.getDescription()))
                .andExpect(jsonPath("$[0].completed").value(todo.isCompleted()))
                .andExpect(jsonPath("$[0].priority").value(todo.getPriority()));
	}

	@Test
	void testCreateTodoFailure() throws Exception {

		var todo = new ToDo("", "", false, 0);

		mockMvc.perform(post("/todos")
               .contentType("application/json")
			   .content(objectMapper.writeValueAsString(todo)))
			   .andExpect(status().isBadRequest());
	}
}
