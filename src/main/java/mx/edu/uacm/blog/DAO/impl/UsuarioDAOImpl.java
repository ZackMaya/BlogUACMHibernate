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

import mx.edu.uacm.blog.DAO.UsuarioDAO;
import mx.edu.uacm.blog.domain.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final Logger log = LogManager.getLogger(UsuarioDAOImpl.class);
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	/**metodo para insertar un usuario**/
	@Override
	public void insertarUsuario(Usuario usuario) {
		log.debug("Entrando al metodo insertarUsuario() en en UsuarioDAOImpl");
		em.persist(usuario);
	}

	
	/**metodo para obtener un usuario mediante su correo y password**/
	@Override
	public Usuario getByEmailAndPassword(String email,String password) {
		log.debug("Entrando Entrando a método getByEmailAndPassword() en UsuarioDAOImpl");
		Usuario usuario;
		try {
		usuario=(Usuario) em.createNativeQuery("select * from Usuario where email=:correo and password=MD5(:contrasena)", Usuario.class).setParameter("correo", email).setParameter("contrasena", password).getSingleResult();
		}catch(NoResultException e){
			usuario=null;
		}
		return usuario;
	}
	

	/**metodo para obtener todos los usuarios**/
	@Override
	public List<Usuario> obtenerUsuariosTodos() {
		log.debug("Entrando a método obtenerUsuariosTodos() en UsuarioDAOImpl");
		TypedQuery<Usuario> consulta = em.createQuery("Select u from Usuario u",Usuario.class);
		return consulta.getResultList();
	}

	/**metodo para encontrar un usuaroio por su mail**/
	@Override
	public Usuario encontrarUsuarioPorEmail(String mail) {
		log.debug("Entrando a método encontrarUsuarioPorEmail() en UsuarioDAOImpl");
		Usuario usuarioEncontrado;
		try {
		usuarioEncontrado=(Usuario) em.createNativeQuery("Select * from usuario where email=:correo",Usuario.class).setParameter("correo",mail).getSingleResult();
		}catch(NoResultException e){
			usuarioEncontrado=null;
		}
		return usuarioEncontrado;
	}

	/**metodo para obtener un usuario por medio de su id**/
	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		log.debug("Entrando a métodoobtenerUsuarioPorId() en UsuarioDAOImpl");
		Usuario usuarioEncontrado;
		try {
		usuarioEncontrado=(Usuario) em.createNativeQuery("Select * from usuario where id=:idUsuario",Usuario.class).setParameter("idUsuario",id).getSingleResult();
		}catch(NoResultException e){
			usuarioEncontrado=null;
		}
		return usuarioEncontrado;
	}



}
