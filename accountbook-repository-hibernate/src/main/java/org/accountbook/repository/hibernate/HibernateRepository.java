package org.accountbook.repository.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.accountbook.domain.Entity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Abstract {@link Repository} implementation, acting as base for all hibernate
 * based repository access.
 * 
 * @author marc
 */
public abstract class HibernateRepository<T extends Entity<T>> implements
		Repository<T> {

	private HibernateTemplate hibernateTemplate;

	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public HibernateRepository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) hibernateTemplate.get(persistentClass, id);
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(T entity) {
		// TODO Auto-generated method stub

	}

	public void saveAll(List<T> entities) {
		// TODO Auto-generated method stub

	}

	public void delete(T entity) {
		// TODO Auto-generated method stub

	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

}
