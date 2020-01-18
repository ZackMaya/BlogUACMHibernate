package mx.edu.uacm.blog.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.blog.DAO.ComentarioDAO;
import mx.edu.uacm.blog.domain.Comentario;

@Repository
@Transactional
public class ComentarioDAOImpl implements ComentarioDAO{

   private static final Logger log = LogManager.getLogger(ComentarioDAOImpl.class);
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	/**metodo para insertar un comentario**/
	@Override
	public void insertarComentario(Comentario comentario) {
		log.debug("ComentarioDAOImpl metodo insertar un comentario");
		em.persist(comentario);
	}


	/**metodo para obtener los comentarios de un post**/
	@Override
	public List<Comentario> obtenerComentarioPorIdPost(Long idPost) {
		
		log.debug("Entrando a obtenerComentarioPorId() en ComentarioDAOImpl");
		log.debug("El id del pos que voy a vuscar en ComentarioDAOImples: "+idPost);
		TypedQuery<Comentario> query=em.createQuery("select c from Comentario c join fetch c.post p where p.id=?1",Comentario.class);
		query.setParameter(1,idPost);
		return  query.getResultList();
	}


	/**metodo para obtener un comentario medienate su id**/
	@Override
	public Comentario obtenerComentarioPorId(Long id) {
		log.debug("Entrando a obtenerComentarioPorId() en ComentarioDAOImpl");
		Comentario comentarioEncontrado;
		try {
			comentarioEncontrado=(Comentario) em.createNativeQuery("Select * from Comentario where id=:idComentario",Comentario.class).setParameter("idComentario",id).getSingleResult();
		}catch(NoResultException e){
			comentarioEncontrado=null;
		}
		return comentarioEncontrado;
	}


	/**metodo para obtener todos los comentarios**/
	@Override
	public List<Comentario> obtenerComentarios() {
		log.debug("Entrando a método obtenerComentarios() en ComentarioDAOImpl");
		TypedQuery<Comentario> consulta = em.createQuery("Select c from Comentario c",Comentario.class);
		return consulta.getResultList();
	}

}
