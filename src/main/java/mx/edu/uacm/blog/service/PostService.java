package mx.edu.uacm.blog.service;

import java.util.List;

import mx.edu.uacm.blog.domain.Post;


public interface PostService {
	
	public void insertarPost(Post post);
	
	public List<Post> obtenerPost();
	
	public Post buscarPostPorId(Long id);

}
