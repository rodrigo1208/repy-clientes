package br.com.rodrigocardoso.repy.mappers;

import javax.enterprise.context.ApplicationScoped;

import org.mapstruct.Mapper;

import br.com.rodrigocardoso.repy.dtos.ClienteDto;
import br.com.rodrigocardoso.repy.entities.Cliente;

@Mapper(config = CustomMapperConfig.class)
@ApplicationScoped
public interface ClienteMapper extends ModelMapper<Cliente, ClienteDto> {
	
}
