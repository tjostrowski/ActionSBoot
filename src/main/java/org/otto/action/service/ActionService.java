package org.otto.action.service;

import org.otto.action.model.Action;
import org.otto.action.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
	
	@Autowired
	private ActionRepository actionRepository;
	
	public void saveAction(Action action) {
		actionRepository.save(action);
	}
}
