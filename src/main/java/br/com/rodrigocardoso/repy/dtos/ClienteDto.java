package br.com.rodrigocardoso.repy.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ClienteDto {
	public String id;
	public String nome;
	
	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", nome=" + nome + "]";
	}
}
