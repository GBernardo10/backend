package br.com.bandtec.bora.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TBD_SUB_CATEGORIA")
public class SubCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sub_categoria")
	private Long id;
	
	@Column(name = "nome_sub_categoria")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	@NotEmpty
	private Categoria categoria;
	
	

	public SubCategoria() {
	}

	public SubCategoria(Long id, String nome, @NotEmpty Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}