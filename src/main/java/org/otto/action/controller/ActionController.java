package org.otto.action.controller;

import org.otto.action.model.Action;
import org.otto.action.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	
	@PostMapping("/create")
	public Long createAction(@RequestBody Action action) {
		actionService.saveAction(action);
		return action.getId();
	}
}
