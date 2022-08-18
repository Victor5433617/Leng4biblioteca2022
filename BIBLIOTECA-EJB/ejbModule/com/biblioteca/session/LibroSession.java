package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.biblioteca.entidad.Libro;

@Stateless
public class LibroSession {
	
	@PersistenceContext (name = "BibliotecaPU")
	EntityManager em;
	
	public List<Libro> buscarTodos() throws Exception {
		
		String jpql = "SELECT o FROM Libro o ORDER BY o.codigo";
		List<Libro> libros = (List<Libro>) em.createQuery(jpql, Libro.class).getResultList();
		return libros;
	}
	
	public Libro buscarPorCodigo(Integer codigo) throws Exception{
		return em.find(Libro.class, codigo);
	}
	
public Libro Actualizar (Libro LibroAct) throws Exception {
		
		Libro libro = buscarPorCodigo(LibroAct.getCodigo()); // Buscar el objeto
		
		if (libro == null) {
			LibroAct.setCodigo(null);
			em.persist(LibroAct);
			em.refresh(LibroAct);
		}else {
			LibroAct = em.merge(LibroAct);
		}
		return LibroAct;
	}
	public void eliminar (Integer codigo) throws Exception{
	Libro libro = buscarPorCodigo(codigo);
	
	if ( libro != null) {
		em.remove(libro);	
	}
	
}
	
}
