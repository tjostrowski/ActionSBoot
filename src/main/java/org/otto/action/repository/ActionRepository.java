package org.otto.action.repository;

import org.otto.action.model.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {
}
