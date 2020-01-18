package mx.edu.uacm.blog.consultas.dao.impl.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.blog.BlogProyectoFinalApplication;
import mx.edu.uacm.blog.DAO.UsuarioDAO;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.UsuarioService;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class ConsultasUsuarioDAOImplTest {
	private static final Logger log=LogManager.getLogger();
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioService usuarioService;
		/**test para obtener un usuario por medio de su id**/
	    @Test
	    public void testObtenerUsuarioPorID() {
	        
	        Usuario usuario =usuarioService.encontrarPorId((long)1);
	        log.debug("El nombre del usuario que encontré por id es: "+usuario.getNombre());
	        assertNotNull(usuario);
	        
	    }
	    
	    /**test para obtener un usuario por medio de correo y password**/
	   @Test
		public void testBuscarUsuarioPorCorreoyPassword() {
			log.debug("Obtener usuario por correo");
			String correo = "maya@gmail.com";
			String password = "12345";
			Usuario usuario = usuarioDAO.getByEmailAndPassword(correo, password);
			assertNotNull(usuario);
			log.debug("id "+usuario.getId());
			log.debug("nombre: "+usuario.getUrl());
			log.debug("nombre: "+usuario.getNombre());
			log.debug("correo: "+usuario.getEmail());
			log.debug("pass: "+usuario.getCuidad());
			log.debug("fecha: "+usuario.getFecha_registro());
		}
	   
	   /**test para obtener todos los usuarios**/
	   @Test
		public void testObtenerTodosLosUsuarios() {
		   log.debug("Entrnado al metodo  testObtenerComentarios");
			List<Usuario> usuarios = usuarioDAO.obtenerUsuariosTodos();
			Assert.assertThat(usuarios, is(not(nullValue())));
			for (Usuario usuario : usuarios) {
				log.debug(usuario.getId());
				log.debug(usuario.getNombre());
				log.debug(usuario.getEmail());
			}
		}
	    /**test para obtener un usuario por medio de correo**/
	   @Test
		public void testBuscarUsuarioPorCorreo() {
			log.debug("Obtener usuario por correo");
			String correo = "maya@gmail.com";
			Usuario usuario = usuarioDAO.encontrarUsuarioPorEmail(correo);
			assertNotNull(usuario);
			log.debug("id "+usuario.getId());
			log.debug("nombre: "+usuario.getUrl());
			log.debug("nombre: "+usuario.getNombre());
			log.debug("correo: "+usuario.getEmail());
			log.debug("pass: "+usuario.getCuidad());
			log.debug("fecha: "+usuario.getFecha_registro());
		}
   
	   /**test para obtener un usuario por medio de su id**/
	   @Test
		public void obtenerComentarioPorId() {
			log.debug("Entrnado al metodo  obtenerComentarioPorId");
			Usuario usuario = usuarioDAO.obtenerUsuarioPorId((long)1);
			log.debug(usuario.getNombre());
			assertNotNull(usuario);
		}

	 
}


