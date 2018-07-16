package org.thepoet.dao;

import org.springframework.data.repository.CrudRepository;
import org.thepoet.model.Hobby;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
public interface HobbyDao extends CrudRepository<Hobby, String> {
}
