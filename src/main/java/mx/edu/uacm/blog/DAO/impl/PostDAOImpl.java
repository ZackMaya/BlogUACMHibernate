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

import mx.edu.uacm.blog.DAO.PostDAO;
import mx.edu.uacm.blog.domain.Post;


@Repository
@Transactional
public class PostDAOImpl implements PostDAO {
	
	private static final Logger log = LogManager.getLogger(PostDAOImpl.class);
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	/**metodo para insertar un post**/
	@Override
	public void insertarPost(Post post) {
			log.debug("Entrando PostDAOImpl insertarPost()");	
		    em.persist(post);
		
	}
	
	
    /**metodo para obtener todos los post**/
	@Override
	public List<Post> obtenerPostTodos() {
		log.debug("Entrando a método obtenerPostTodos() en PostDAOImpl");
		TypedQuery<Post> consulta = em.createQuery("Select u from Post u",Post.class);
		return consulta.getResultList();
	}

	
	/**metodo para realizar la busqueda de un post mediante su id**/
	@Override
	public Post buscarPostPorId(Long id) {
		log.debug("Entrando a método buscarPostPorId() en PostDAOImpl");
		Post pstEncontrado;
		try {
			pstEncontrado=(Post) em.createNativeQuery("Select * from Post  where id=:idPost",Post.class).setParameter("idPost",id).getSingleResult();
		}catch(NoResultException e){
			pstEncontrado=null;
		}
		return pstEncontrado;
	}
	
	

}
