package br.com.rodrigocardoso.repy.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;

@Entity
@RegisterForReflection
public class Cliente extends PanacheEntityBase {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition =  "uuid")
	public UUID id;
	public String nome;
	@OneToMany( cascade = CascadeType.ALL )
	public List<Telefone> telefones;
}
