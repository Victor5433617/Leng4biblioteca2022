package com.biblioteca.entidad;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "autores")

 // Este es el campo nombre

public class Autor {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //Poner asi cuando es tipo serial 
	@Column (name= "aut_codigo")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "aut_ciudad")
	private Ciudad ciudad;
	
	@Column (name= "aut_nombre")
	private String nombre;
	
	@Column (name= "aut_foto")
	private byte[] foto;
	public Autor() {
		super();
		
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
