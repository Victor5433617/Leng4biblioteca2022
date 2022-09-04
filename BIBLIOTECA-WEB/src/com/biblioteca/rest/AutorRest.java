package com.biblioteca.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.biblioteca.entidad.Autor;
import com.biblioteca.session.AutorSession;

@Path("/autor")
public class AutorRest {

	@EJB
	AutorSession as;
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String,Object> consultar (String Nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("sucess", true);
			retorno.put("result", as.consultarAutores());
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("error",e.getMessage());
		}
		return retorno;
	}
//----------------------------------------------------------------------------------
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	
	public Map<String, Object> consultarPorNombre(@QueryParam ("nombre") String nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			 retorno.put("sucess",true);
			 retorno.put("result", as.consultarAutoresPorNombre(nombre));
		} catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
			
		}
		return retorno;
	}
//----------------------------------------------------------------------------------
	@POST
	@Produces (MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Map<String,Object>  incluir (Autor autor) {
		Map<String,Object> retorno= new HashMap<String,Object>();
		try {
			retorno.put("sucess", true);
			retorno.put("result", as.incluir(autor));
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("Error", e.getMessage());
		}
		return retorno;
	}
//----------------------------------------------------------------------------------
	@POST
	@Produces (MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Map<String, Object> actualizar (Autor autor) {
		Map<String,Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("sucess", true);
			retorno.put("result",as.Actualizar(autor));
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("result", e.getMessage());
			
		}
		return retorno;
	}
//----------------------------------------------------------------------------------
	@DELETE
	@Path("/eliminar/{id}")
	public Map<String, Object> eliminar(@PathParam ("id") Integer codigo) {
		 Map<String,Object> retorno = new HashMap<String, Object>();
		 try {
			retorno.put("success", true);
			as.eliminar(codigo);
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("result", e.getMessage());
		}
		 return retorno;

	}
//----------------------------------------------------------------------------------	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/buscarPorcodigo")
	public Map<String, Object> buscarPorCodigo (@QueryParam("codigo")Integer codigo){
		Map<String,Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("sucess", true);
			retorno.put("result", as.buscarporCodigo(codigo));
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("result", e.getMessage());
		}
		return retorno;
	}
//----------------------------------------------------------------------------------	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/editar")
	public Map<String,Object> editar (Autor autor){
		Map<String,Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("sucess", true);
			retorno.put("result", as.Editar(autor));
		} catch (Exception e) {
			retorno.put("sucess", false);
			retorno.put("result",e.getMessage());
		}
		return retorno;
	}
	
	
	
}
