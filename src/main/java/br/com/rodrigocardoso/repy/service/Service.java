package br.com.rodrigocardoso.repy.service;

import java.util.List;

public interface Service <Entity, Id> {
	Entity save(Entity entity);
	Entity update(Id id, Entity entity);
	void delete(Id id);
	List<Entity> getAll();
	Entity getById(Id id);
}
