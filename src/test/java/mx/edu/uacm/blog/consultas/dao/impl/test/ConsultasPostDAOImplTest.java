package mx.edu.uacm.blog.consultas.dao.impl.test;

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
import mx.edu.uacm.blog.DAO.PostDAO;
import mx.edu.uacm.blog.domain.Post;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class ConsultasPostDAOImplTest {
	
	private static final Logger log = LogManager.getLogger(ConsultasPostDAOImplTest.class);
	@Autowired
	private PostDAO postDAO;
	
	
	/**Test para obtener todos los post**/
    @Test
	public void testObtenerTodosPost() {
		log.debug("Entrando testObtenerTodosPost");
		
		
		List<Post> posts=postDAO.obtenerPostTodos();
		Assert.assertThat(posts, is(not(nullValue())));
		for (Post post : posts) {
			log.debug("Título del post: "+post.getTitulo());
			log.debug("Contenido del post: "+post.getContenido_post());
			log.debug("Fecha de publicacion del post: "+post.getFecha_post());
			log.debug("Cantidad de comentatios del post: "+post.getComentarios().size());
			
			
		}
	
	}
    
    /**Test para buscar post por ID**/
    @Test
 	public void testBuscarPostPorId() {
 		log.debug("Entrando testBuscarPostPorId");
 		Post post=postDAO.buscarPostPorId((long) 3);
 		Assert.assertThat(post, is(not(nullValue())));
 		log.debug("Contenido del post: "+post.getContenido_post());
 	
 	
 	}
    
    
	

}
