package br.com.rodrigocardoso.repy.resources;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.rodrigocardoso.repy.mappers.ModelMapper;
import br.com.rodrigocardoso.repy.service.Service;

public abstract class AbstractResource <S extends Service<Entity, UUID>, Entity, Dto> {
	
	protected S service;
	protected ModelMapper<Entity, Dto> mapper;
	
	public AbstractResource() {}
	
	public AbstractResource(S service, ModelMapper<Entity, Dto> mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Dto add(Dto body) {
		var entity = mapper.toEntity(body);
		service.save(entity);
		return mapper.toDto(entity);
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("{id}")
	public Dto update(@PathParam("id") String id, Dto body) {
		var entity = mapper.toEntity(body);
		service.update(UUID.fromString(id), entity);
		return mapper.toDto(entity);
	}
	
	@GET
	@Produces("application/json")
	@Path("{id}")
	public Dto getById(@PathParam("id") String id) {
		return mapper.toDto(service.getById(UUID.fromString(id)));
	}

	@GET
	@Produces("application/json")
	public List<Dto> getAll() {
		return service.getAll().stream().map(entity -> mapper.toDto(entity)).collect(toList());
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {
		service.delete(UUID.fromString(id));
		return Response.ok().build();
	}
}
