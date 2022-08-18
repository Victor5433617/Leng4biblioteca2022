package com.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "pre_numero")
	private Integer numero;
	
	@Column (name = "pre_cliente")
	private Integer cliente;
	
	@Column (name = "pre_usuario")
	private Integer usuario;

	@Column (name = "pre_fehca")
	private String fecha;
	
	@Column (name = "pre_situacion")
	private Integer situacion;
	
	@Column (name = "pre_total")
	private Integer total;

	public Prestamo() {
		super();
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getSituacion() {
		return situacion;
	}

	public void setSituacion(Integer situacion) {
		this.situacion = situacion;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
}
