package br.com.rodrigocardoso.repy.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

public abstract class EntityService <T extends PanacheEntityBase> implements Service<T, UUID> {
	
	protected Class<T> clazz;
	
	public EntityService(Class<T> clazz) {
		this.clazz = clazz;
	}
	
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
		var old = (T) JpaOperations.findById(clazz, id);
		
		if (old == null) return null;
		
		old.getEntityManager().merge(entity);
		
		old.persist();
		return entity;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>) JpaOperations.findAll(clazz).list();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public T getById(UUID id) {
		return (T) JpaOperations.findById(clazz, id);
	}
	
	@Override
	@Transactional
	public void delete(UUID id) {
		JpaOperations.deleteById(clazz, id);
	}
	
}  
