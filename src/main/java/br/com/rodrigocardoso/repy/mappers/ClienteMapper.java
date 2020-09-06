package br.com.rodrigocardoso.repy.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;

import br.com.rodrigocardoso.repy.dtos.ClienteDto;
import br.com.rodrigocardoso.repy.entities.Cliente;

@Mapper(config = CustomMapperConfig.class)
public interface ClienteMapper extends ModelMapper<Cliente, ClienteDto> {
	default UUID stringToUUID(String id) {
		if (id == null) return null;
		return UUID.fromString(id);
	}
	
	default String uuidToString(UUID id) {
		if (id == null) return null;
		return id.toString();
	}
}
