package br.com.fiap.spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estacionamento")
public class Estacionamento {

	@Id
	@Column(name = "id_estacionamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estacionamento")
	@SequenceGenerator(name = "estacionamento", sequenceName = "sq_tb_estacionamento", allocationSize = 1)
	private Integer id;
	
	@Column(name = "nm_estacionamento", nullable=false, length = 100)
	private String nome;
	
	@Column(name = "nm_endereco", nullable=false)
	private String endereco;
	
	@Column(name = "nr_vagas")
	private int vagas;
	
	@Column(name = "vl_estacionamento")
	private float preco;
	
	public Estacionamento() {
		
	}

	public Estacionamento(Integer id, String nome, String endereco, int vagas, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.vagas = vagas;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	
}
