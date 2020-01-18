package mx.edu.uacm.blog.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.blog.DAO.PostDAO;
import mx.edu.uacm.blog.domain.Post;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private static final Logger log=LogManager.getLogger(PostServiceImpl.class);
	
	@Autowired
	private PostDAO postDAO;

	@Override
	public void insertarPost(Post post) {
		
		log.debug("Entrando a método en insertarPOst PostServiceImpl");
		
		postDAO.insertarPost(post);
		
	}

	@Override
	public List<Post> obtenerPost() {
		log.debug("Entrando a método obtenerPost() en PostServiceImpl");
		return postDAO.obtenerPostTodos();
	}

	@Override
	public Post buscarPostPorId(Long id) {
		log.debug("Entrando a método buscarPostPorId() en PostServiceImpl");
		return postDAO.buscarPostPorId(id);
	}
	

}
