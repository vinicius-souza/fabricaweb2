package fabricaweb2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager="transactionManager")
public class testUsuarioService {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuarioDAO;

	// anotação indica que está esperando uma exception
	@Test(expected = ServiceException.class)
	public void testNaoDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("testeSalvar");
		usu.setNome("TESTE SALVAR");
		usu.setSenha("senha teste");
		
		//Ignora a regra de negocio e garante que o usuario estara salvo no banco
		usuarioDAO.salvar(usu);

		usuarioService.salvar(usu);

	}

	@Test
	@Transactional
	public void testDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("tL1");
		usu.setNome("TE111");
		usu.setSenha("s111");
						
		usuarioService.salvar(usu);

	}

}
