package mx.edu.uacm.blog.DAO;

import java.util.List;

import mx.edu.uacm.blog.domain.Usuario;

public interface UsuarioDAO {
	
	public void insertarUsuario(Usuario usuario);
	
	Usuario getByEmailAndPassword(String mail, String password);
	
	Usuario obtenerUsuarioPorId(Long id);
	
	List<Usuario> obtenerUsuariosTodos();
	
	Usuario encontrarUsuarioPorEmail(String mail);
}
