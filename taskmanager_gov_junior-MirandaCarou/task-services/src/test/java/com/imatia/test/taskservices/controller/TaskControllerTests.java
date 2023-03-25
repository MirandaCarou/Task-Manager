package com.imatia.test.taskservices.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imatia.test.taskservices.model.Task;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-tests.yml")
@AutoConfigureMockMvc
class TaskControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void validGetDefaultTaskRequest_thenReturns200() throws Exception {
		MvcResult result = this.mvc.perform(get("/task/default")).andExpect(status().isOk()).andReturn();
		Task resultTask = objectMapper.readValue(result.getResponse().getContentAsString(), Task.class);
		assertEquals("Tarea por defecto", resultTask.getName());
	}

}
