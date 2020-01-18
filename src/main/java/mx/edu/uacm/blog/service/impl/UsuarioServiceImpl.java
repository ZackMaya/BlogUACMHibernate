package mx.edu.uacm.blog.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.blog.DAO.UsuarioDAO;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger log=LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void insertarUsuario(Usuario usuario) {
		
		log.debug("Entrando a método insertarUsuario() en UsuarioServiceImpl");
		usuarioDAO.insertarUsuario(usuario);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		log.debug("Entrando a método obtenerUsuarios() en UsuarioServiceImpl");
		return usuarioDAO.obtenerUsuariosTodos();
	}

	@Override
	public Usuario validarUsuarioyContraseña(String email, String password) {
		log.debug("Entrando a método validarUsuarioyContraseñas() en UsuarioServiceImpl");
		return usuarioDAO.getByEmailAndPassword(email,password);
		
	}

	@Override
	public Usuario encontrarPorEmail(String email) {
		log.debug("Entrando a método vencontrarPorEmail() en UsuarioServiceImpl");
		return usuarioDAO.encontrarUsuarioPorEmail(email);
		
	}
		
	@Override
	public Usuario encontrarPorId(Long id) {
		log.debug("Entrando a método vencontrarPorEmail() en UsuarioServiceImpl");
		return usuarioDAO.obtenerUsuarioPorId(id);
	}
		

}
