package br.com.rodrigocardoso.repy.resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import br.com.rodrigocardoso.repy.dtos.ClienteDto;
import br.com.rodrigocardoso.repy.entities.Cliente;
import br.com.rodrigocardoso.repy.mappers.ClienteMapper;
import br.com.rodrigocardoso.repy.service.ClienteService;

@Path("/clientes")
public class ClienteResource extends AbstractResource<ClienteService, Cliente, ClienteDto> {
	
	public ClienteResource() { }
	
	@Inject
	public ClienteResource(ClienteService service, ClienteMapper mapper) {
		super(service, mapper);
	}
}
