package mx.edu.uacm.blog.test.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

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



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class UsuarioTest {
	
	private static final Logger log=LogManager.getLogger();
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
    @Test
	public void testObtenerUsuariosyActividad() {
		log.debug("Entrando testObtenerUsuariosyActividad");
		
		
		List<Usuario> usuarios=usuarioDAO.obtenerUsuariosTodos();
		Assert.assertThat(usuarios, is(not(nullValue())));
		for (Usuario usuario : usuarios) {
			log.debug("Nombre del usuario: "+usuario.getNombre());
			log.debug("Post publicados: "+usuario.getPosts().size());
			log.debug("Comentarios publicados: "+usuario.getComentarios().size());
			
			
			  /*List<Post> posts= usuario.getPosts();
	            for (Post post :posts) {
	            
	                log.debug(post.getComentarios());
	            }*/
			
		}
	
	}
	

}
