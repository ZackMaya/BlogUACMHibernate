package mx.edu.uacm.blog.service;

import java.util.List;
import mx.edu.uacm.blog.domain.Comentario;
import mx.edu.uacm.blog.domain.Post;


public interface ComentarioService {
	public void insertarComentario(Comentario comentario);
	
	public Comentario obtenerComentarioId(Long id);
	
	public List<Comentario> obtenerComentarios();

	public List<Comentario> obtenerComentariosPorIdPost(Long idArti);

}
