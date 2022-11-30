package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Animal extends Model{

	public String nome;
	public Integer peso;
	
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;

	@Override
	public String toString() {
		return nome;
	}

	@ManyToOne
	public TipoAnimal tipoAnimal;
	
	public Animal() {
		status = Status.ATIVO;
	}

	@Enumerated(EnumType.STRING)
	public Status status;
	
}