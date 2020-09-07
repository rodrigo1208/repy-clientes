package br.com.rodrigocardoso.repy.service;

import javax.enterprise.context.ApplicationScoped;

import br.com.rodrigocardoso.repy.entities.Cliente;

@ApplicationScoped
public class ClienteService extends EntityService<Cliente> {
	public ClienteService() {
		super(Cliente.class);
	}
}
