package mx.edu.uacm.blog.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.blog.DAO.ComentarioDAO;
import mx.edu.uacm.blog.domain.Comentario;
import mx.edu.uacm.blog.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService{
	
	private static final Logger log=LogManager.getLogger(ComentarioServiceImpl.class);

	
	@Autowired
	private ComentarioDAO comentarioDAO;
	@Override
	public void insertarComentario(Comentario comentario) {

		log.debug("Entrando a método insertar comentario en ComentarioServiceImpl");
		comentarioDAO.insertarComentario(comentario);
		
	}
	@Override
	public Comentario obtenerComentarioId(Long id) {
		log.debug("Entrando a método obtenerComentarioId ComentarioServiceImpl");
	  return comentarioDAO.obtenerComentarioPorId(id);
	}
	@Override
	public List<Comentario> obtenerComentarios() {
		log.debug("Entrando a método obtenerComentarios en ComentarioServiceImpl");
		return comentarioDAO.obtenerComentarios();
	}
	@Override
	public List<Comentario> obtenerComentariosPorIdPost(Long idPost) {
		log.debug("Entrando a método insertar comentario en ComentarioServiceImpl");
		return comentarioDAO.obtenerComentarioPorIdPost(idPost);
	}
	

}
