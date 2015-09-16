package br.com.fabricadeprogramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;


@Service
public class UsuarioService {
	
	@Autowired
	@Qualifier(value="usuarioDAOJPA")
	UsuarioDAO usuarioDAO;
	
	public Usuario salvar(Usuario usuario) throws ServiceException{
		
		//Verificações
		
		Usuario usuExistente = usuarioDAO.buscarLogin(usuario.getLogin());
		
		//Já existe
		if(usuExistente != null)
			throw new ServiceException("Usuario já existe!");
		usuarioDAO.salvar(usuario);
		return usuarioDAO.salvar(usuario);
	}

}
