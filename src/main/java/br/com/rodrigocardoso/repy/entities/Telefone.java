package br.com.rodrigocardoso.repy.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Telefone extends PanacheEntityBase {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public UUID id;
	public String descricao;
	public String numero;
	@ManyToOne
	public Cliente cliente;
}
