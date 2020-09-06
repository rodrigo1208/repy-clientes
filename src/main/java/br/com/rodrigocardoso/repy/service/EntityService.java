package br.com.rodrigocardoso.repy.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.ws.rs.PathParam;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

public abstract class EntityService <T extends PanacheEntityBase> implements Service<T, UUID> {
	
	@Override
	@Transactional
	public T save(T entity) {
		entity.persist();
		return entity;
	}
	
	@Override
	@Transactional
	public T update(UUID id, T entity) {
		@SuppressWarnings("unchecked")
		var old = (T) JpaOperations.findById(reference(), id);
		
		if (old == null) return null;
		
		old.getEntityManager().merge(entity);
		
		old.persist();
		return entity;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>) JpaOperations.findAll(reference()).list();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public T getById(UUID id) {
		return (T) JpaOperations.findById(reference(), id);
	}
	
	@Override
	public void delete(UUID id) {
		JpaOperations.deleteById(reference(), id);
	}
	
	public abstract Class<T> reference();
}  
