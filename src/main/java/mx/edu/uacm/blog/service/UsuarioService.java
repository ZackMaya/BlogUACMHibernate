package mx.edu.uacm.blog.service;

import java.util.List;

import mx.edu.uacm.blog.domain.Usuario;


public interface UsuarioService {
	
	public void insertarUsuario(Usuario usuario);
	Usuario  validarUsuarioyContraseña(String email,String password);
	public List<Usuario> obtenerUsuarios();
	Usuario encontrarPorEmail(String email);
	Usuario encontrarPorId(Long id);
}
