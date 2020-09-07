package br.com.rodrigocardoso.repy.mappers;

import java.util.UUID;

public interface ModelMapper <Entity, Dto> {
	Dto toDto(Entity entity);
	Entity toEntity(Dto dto);
	
	default UUID stringToUUID(String id) {
		if (id == null) return null;
		return UUID.fromString(id);
	}
	
	default String uuidToString(UUID id) {
		if (id == null) return null;
		return id.toString();
	}
}
