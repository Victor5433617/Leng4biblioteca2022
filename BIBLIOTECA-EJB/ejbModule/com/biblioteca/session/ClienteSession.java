package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import com.biblioteca.entidad.Cliente;


@Stateless
public class ClienteSession {
	@PersistenceContext (name = "BibliotecaPU")
	EntityManager em;
	
public List<Cliente> buscarTodos() throws Exception {
		
		String jpql = "SELECT o FROM clientes o ORDER BY o.codigo";
		List<Cliente> clientes = (List<Cliente>) em.createQuery(jpql, Cliente.class).getResultList();
		return clientes;
	}

		public Cliente buscarPorCodigo(Integer codigo) throws Exception{
	return em.find(Cliente.class, codigo);
		}

		public Cliente Actualizar (Cliente ClienteAct) throws Exception {
	
	Cliente Cliente = buscarPorCodigo(ClienteAct.getCodigo()); // Buscar el objeto
	
	if (Cliente == null) {
		ClienteAct.setCodigo(null);
		em.persist(ClienteAct);
		em.refresh(ClienteAct);
	}else {
		ClienteAct = em.merge(ClienteAct);
	}
	return ClienteAct;
		}
	public void eliminar (Integer codigo) throws Exception{
			Cliente Cliente = buscarPorCodigo(codigo);
			if ( Cliente != null) {
				em.remove(Cliente);	
			}
		}
}
