package br.com.bandtec.bora.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tbd_usuario_evento")
public class UsuarioEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_evento")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "evento_id")
	@JsonIgnoreProperties
	private Evento evento;
	
	@Column(name = "is_organizador" , nullable = false)
	private boolean isOrganizador; 
	
	
	
	public UsuarioEvento() {
	}

	public UsuarioEvento(Usuario usuario, Evento evento) {
		this.usuario = usuario;
		this.evento = evento;
	}
}