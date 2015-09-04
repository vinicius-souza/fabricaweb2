package br.fabricadeprogamador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.entidade.Usuario;
@Repository
public class UsuarioDAO {
	//Dependência
	@PersistenceContext
	EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}


	public void salvar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}

	public Usuario buscarPorId(int id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {
		Query q = em.createQuery("select u from Usuario u");
		
		return q.getResultList();
	}
	
	public void excluir(Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}

}
