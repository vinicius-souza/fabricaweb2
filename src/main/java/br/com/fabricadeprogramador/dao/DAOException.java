package br.com.fabricadeprogramador.dao;

public class DAOException extends Exception {
	
	//Construtor recebendo a causa da exceção
	public DAOException(String msg, Exception e) {
		super(msg, e);
	}

}
