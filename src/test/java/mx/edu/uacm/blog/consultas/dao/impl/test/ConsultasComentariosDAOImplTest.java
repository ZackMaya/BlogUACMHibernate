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
import mx.edu.uacm.blog.DAO.ComentarioDAO;
import mx.edu.uacm.blog.domain.Comentario;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class ConsultasComentariosDAOImplTest {
	private static final Logger log=LogManager.getLogger();
	
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	
	   /**Test para recuperar todos los comentarios**/
	   @Test
	    public void testObtenerComentarios() {
		 log.debug("Entrnado al metodo  testObtenerComentarios");
			List<Comentario> commentarios = comentarioDAO.obtenerComentarios();
			Assert.assertThat(commentarios, is(not(nullValue())));
			for (Comentario comentario : commentarios) {
				log.debug(comentario.getId());
				log.debug(comentario.getContenidoComnetario());
				log.debug(comentario.getFechaComentario());
			}
	    }
	  
	
	    /**Test para recuperar un comentario por dado su id**/
		@Test
		public void obtenerComentarioPorId() {
			log.debug("Entrnado al metodo  obtenerComentarioPorId");
			Comentario comentarios = comentarioDAO.obtenerComentarioPorId((long)4);
			log.debug(comentarios.getContenidoComnetario());
			assertNotNull(comentarioDAO);
		}

	   /**Test para recuperar los comentarios de un post determinado**/
	    @Test
		public void testObtnerTodosLosComentariosPorIdPost() {
			log.debug("Entrnado al metodo testObtnerTodosLosComentariosPorArt");
			List<Comentario> commenentarios = comentarioDAO.obtenerComentarioPorIdPost((long)3);
			
			log.debug("Lista de comentarios: " + commenentarios.size());
			Assert.assertThat(commenentarios,is(not(nullValue())));
			for (Comentario comentario : commenentarios) {
				log.debug(comentario.getId());
				log.debug(comentario.getContenidoComnetario());
				log.debug(comentario.getFechaComentario());
			}
		}
			
		

	 
}


