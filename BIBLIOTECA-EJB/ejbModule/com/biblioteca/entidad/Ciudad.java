package com.biblioteca.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "ciudades")
public class Ciudad {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ciu_codigo")
	private Integer codigo;
	
	//@OneToMany
	//private List<Autor> autores;
	
	@Column (name = "ciu_descripcion")
	private String descripcion;

	public Ciudad() {
		super();
		
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
