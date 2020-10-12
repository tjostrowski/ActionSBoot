package org.otto.action.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.otto.action.model.Action;
import org.otto.action.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ActionController.class)
public class ActionControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
    private ActionService service;
	
	@Test
	public void testSaveAction() throws Exception {
		ArgumentCaptor<Action> captor = ArgumentCaptor.forClass(Action.class);
		
		mvc.perform(post("/create").content("{\"userId\": 2, \"gameId\": 3, \"action\": \"ADD\"}")
				.contentType("application/json")).andExpect(status().isOk());
		
		verify(service).saveAction(captor.capture());
		Action savedAction = captor.getValue();
		assertEquals(2, savedAction.getUserId());
		assertEquals(3, savedAction.getGameId());
		assertEquals("ADD", savedAction.getAction());
	}
}
