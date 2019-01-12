package com.example.springbootexample1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootExample1ApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void getThisIsFoo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("This is foo"));
	}

	@Test
	public void getNumber3() throws Exception {
		mvc.perform((MockMvcRequestBuilders.get("/number").accept(MediaType.APPLICATION_JSON)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("3"));
	}

	@Test
	public void getPerson() throws Exception {
		mvc.perform((MockMvcRequestBuilders.get("/person").accept(MediaType.APPLICATION_JSON)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("{\"name\":\"name1\",\"age\":32}"));
	}

	@Test
	public void getError() throws Exception {
		mvc.perform((MockMvcRequestBuilders.get("/abc").accept(MediaType.APPLICATION_JSON)))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
}

