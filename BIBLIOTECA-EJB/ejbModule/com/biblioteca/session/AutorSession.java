package com.biblioteca.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Autor;


@Stateless
public class AutorSession {
	
	@PersistenceContext ( name = "BibliotecaPU" )
	EntityManager em;
	
	public List<Autor> consultarAutores(){
		String jpql= "SELECT  a FROM  Autor a ORDER BY a.codigo";
		Query q = em.createQuery(jpql);
		List<Autor> autores = q.getResultList();
		return autores;
	}
	
	public Map<String, Object> consultarAutoresPorNombre (String nombre){
		
		Map<String, Object> retorno = new HashMap<String, Object>();
	try {
		String jpql= "SELECT  a FROM  Autor a "
				+ "WHERE UPPER (a.nombre) LiKE :n "
				+ "ORDER BY a.codigo";
		Query q = em.createQuery(jpql);
		q.setParameter("n","%" + nombre.toUpperCase() + "%" );
		List<Autor> autores = q.getResultList();
		retorno.put("success", true);
		retorno.put("result", autores);
	} catch (Exception e) {
		retorno.put("success", false);
		retorno.put("error", e.getMessage());
	}
		return retorno;
		
	}
	
	public Autor buscarporCodigo(Integer codigo) {
		Autor autor = em.find(Autor.class, codigo);
		return autor;
	}
	
	//Insertar un autor en la base de datos
	//Utilizando Entity Manager
	public Autor incluir (Autor autor) {
		em.persist(autor);  // insertar 
		em.refresh(autor); //consulta de dato insertado
		return autor;
	}
	
	public Autor Editar(Autor autor) {
		autor = em.merge(autor); //El mismo retorna al objeto 
		return autor;
	}
	
	//Incluye o edita un autor dependiento si existe o no.
	private Autor Actualizar (Autor autor) {
		Autor autorActualizado = null;
		Autor autorBuscar = buscarporCodigo(autor.getCodigo());
		if (autorBuscar == null) {
			incluir(autor);
		}else {
			Editar(autor);
		}
		return autorActualizado;

	}
	
	public void eliminar (Integer codigo) {
		Autor autorBuscar = em.find(Autor.class, codigo);
		em.remove(autorBuscar);
		
	}
}
