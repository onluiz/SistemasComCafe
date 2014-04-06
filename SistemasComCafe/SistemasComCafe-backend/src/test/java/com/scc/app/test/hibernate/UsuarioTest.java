package com.scc.app.test.hibernate;

import org.jasypt.util.password.PasswordEncryptor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.scc.app.dao.usuario.UsuarioDAO;
import com.scc.app.model.Usuairo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/coreContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class UsuarioTest {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PasswordEncryptor passwordEncryptor;
	
	@Test
	@Ignore
	public void persist() {
		Usuairo usuario = new Usuairo();
		usuario.setUsername("luiz");
		usuario.setPassword(passwordEncryptor.encryptPassword("12345"));
		usuario.setAtivo(true);
		usuarioDAO.persist(usuario);
	}

}
