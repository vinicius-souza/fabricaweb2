package fabricaweb2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.dao.UsuarioDAOJPA;
import br.com.fabricadeprogramador.entidade.Usuario;

public class TestUsuarioDAO {

	EntityManager em;
	ClassPathXmlApplicationContext ctx;
	UsuarioDAOJPA usuarioDAO;

	// Método que inicializa o contexto do Spring e é executado ANTES do Teste
	@Before
	public void init() {
		// Carregando Contexto do Spring
		ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx
				.getBean("entityManagerFactory");

		em = emf.createEntityManager();

		// Criando UsuarioDAO
		usuarioDAO = new UsuarioDAOJPA(em);
	}

	@After
	public void finaliza() {

		ctx.close();
	}

	@Test
	public void testSalvar() {
		// Cria um novo usuario (para não precisar saber quem está cadastrado no
		// banco)
		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setNome("Jão da Silva");
		usu.setLogin("jj");
		usu.setSenha("123456789");

		usu = usuarioDAO.salvar(usu);

		Assert.assertNotNull(usu.getId());

	}// testSalvar

	@Test
	public void testBuscaPorId() {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setNome("test");
		usu.setLogin("test");
		usu.setSenha("test");

		Usuario usuSalvo = usuarioDAO.salvar(usu);
		Integer idSalvo = usuSalvo.getId();

		Usuario usuBuscado = usuarioDAO.buscarPorId(idSalvo);

		Assert.assertEquals(usuSalvo, usuBuscado);
	}

	@Test
	public void testExcluir() throws DAOException {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setNome("test1");
		usu.setLogin("test1");
		usu.setSenha("test1");

		Usuario u = usuarioDAO.salvar(usu);
		Integer idSalvo = u.getId();

		usuarioDAO.excluir(u);

		Assert.assertEquals(usuarioDAO.buscarPorId(idSalvo), null);

	}// testExcluir

	@Test
	public void testBuscarTodos() {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setNome("test2");
		usu.setLogin("test2");
		usu.setSenha("test2");
		
		//Salvar Usuario de teste
		usuarioDAO.salvar(usu);
		
		List<Usuario> list = usuarioDAO.buscarTodos();
		System.out.println(list.toString());
		Assert.assertNotNull(list);

	}

}
