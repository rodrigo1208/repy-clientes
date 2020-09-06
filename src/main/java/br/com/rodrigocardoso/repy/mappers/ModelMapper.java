package br.com.rodrigocardoso.repy.mappers;

public interface ModelMapper <Entity, Dto> {
	Dto toDto(Entity entity);
	Entity toEntity(Dto dto);
}
