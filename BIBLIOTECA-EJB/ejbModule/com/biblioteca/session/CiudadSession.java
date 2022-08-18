package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.biblioteca.entidad.Ciudad;

@Stateless
public class CiudadSession {
	@PersistenceContext (name = "BibliotecaPU")
	EntityManager em;
	
	public List<Ciudad> buscarTodos() throws Exception{
		String jpql = "SELECT o FROM ciudad o ORDER BY o.codigo";
		List<Ciudad> ciudades = (List<Ciudad>) em.createQuery(jpql, Ciudad.class).getResultList();
		return ciudades;
		
	}
	
	public Ciudad buscarPorCodigo(Integer codigo) throws Exception{
		return em.find(Ciudad.class, codigo);
	}
	
	public Ciudad Actualizar (Ciudad ciudadAct) throws Exception {
		
		Ciudad ciudad = buscarPorCodigo(ciudadAct.getCodigo()); // Buscar el objeto
		
		if (ciudad == null) {
			ciudadAct.setCodigo(null);
			em.persist(ciudadAct);
			em.refresh(ciudadAct);
		}else {
			ciudadAct = em.merge(ciudadAct);
		}
		return ciudadAct;
	}
	public void eliminar (Integer codigo) throws Exception{
		Ciudad ciu = buscarPorCodigo(codigo);
		em.remove(ciu);
	}
}
