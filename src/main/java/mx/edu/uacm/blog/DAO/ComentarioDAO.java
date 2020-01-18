package mx.edu.uacm.blog.DAO;

import java.util.List;

import mx.edu.uacm.blog.domain.Comentario;

public interface ComentarioDAO {
	
	public void insertarComentario(Comentario comentario);
	
	Comentario obtenerComentarioPorId(Long id);
	
	List<Comentario> obtenerComentarioPorIdPost(Long idPost);
	
	List<Comentario> obtenerComentarios();
	
	
	

}
