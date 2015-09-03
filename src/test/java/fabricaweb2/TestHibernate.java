package fabricaweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.fabricadeprogamador.dao.UsuarioDAO;

public class TestHibernate {

	public static void main(String[] args) {
		
		//Fabrica de EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");

		//Gerenciador de Entidades
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("Teste");
		usu.setLogin("tt");
		usu.setSenha("123345");
						
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		//usuarioDAO.salvar(usu);
		
		Usuario usuModificar = usuarioDAO.buscarPorId(3);
		//usuModificar.setLogin("Zé");
		
		//usuarioDAO.salvar(usuModificar);
		
		usuarioDAO.excluir(usuModificar);
		
		//System.out.println(usuModificar);
	}

}
