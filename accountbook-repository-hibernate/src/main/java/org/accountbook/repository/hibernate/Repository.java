package org.accountbook.repository.hibernate;

import java.io.Serializable;
import java.util.List;

import org.accountbook.domain.Entity;

/**
 * Repository interface, based on the ddd book.
 * 
 * @author marc
 */
public interface Repository<T extends Entity<T>, ID extends Serializable> {

	/**
	 * Load entity by provided unique <code>id</code> (PK)
	 * 
	 * @param id
	 *            unique identifier of entity
	 * @return entity loaded entity
	 */
	T loadById(ID id);
	
	
	/**
	 * Load all entities of type T.
	 * 
	 * @return list of loaded entities
	 */
	List<T> loadAll();

	/**
	 * Persists the given <code>entity</code>.
	 * 
	 * @param entity
	 *            to persist
	 */
	void save(T entity);

	/**
	 * Persists a list of entities.
	 * 
	 * @param entities
	 *            a list of entities
	 */
	void saveAll(List<T> entities);

	/**
	 * Removes the persistent <code>entity</code> from our database.
	 * 
	 * @param entity
	 *            to remove
	 */
	void delete(T entity);

}
