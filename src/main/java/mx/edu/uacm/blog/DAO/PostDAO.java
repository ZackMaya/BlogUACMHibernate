package mx.edu.uacm.blog.DAO;

import java.util.List;

import mx.edu.uacm.blog.domain.Post;
import mx.edu.uacm.blog.domain.Usuario;

public interface PostDAO {
	
	public void insertarPost(Post post);
		
	List<Post> obtenerPostTodos();
	
	Post buscarPostPorId(Long id);

}
