package mx.edu.uacm.blog.controller.impl.test;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.HashMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import mx.edu.uacm.blog.BlogProyectoFinalApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
@AutoConfigureMockMvc  //configurar mvc
public class PostControllerTest {
	
	private static final Logger log = LogManager.getLogger(PostControllerTest.class);
	@Autowired
	private MockMvc mvc;
	
	
	
	
	
	/**test para home**/
	@Test
	public void testPost() throws Exception {
		
		log.debug("entrando a testHome");
		mvc.perform(post("/post")).andExpect(view().name("post"));
	}
	
	
	/**test para escribir un post**/
	@Test
	public void tesEscribirPOst() throws Exception {
		log.debug("Entrando a tesEscribirPOst");
		
		HashMap<String, Object> seesionAttribute = new HashMap<String, Object>();
		seesionAttribute .put("userID", new Long(1));
		
		mvc.perform(post("/postinsert").sessionAttrs(seesionAttribute).param("titulo", "thymeleaf").param("url", "https://thymeleaf.org").param("contenido", "<p>\r\n" + 
				"\r\n" + 
				"</p><p><strong>Thymeleaf</strong>&nbsp;es un motor de plantillas de Java moderno para servidores tanto para entornos web como independientes.</p><p>El objetivo principal de Thymeleaf es llevar <em>plantillas naturales</em>&nbsp;elegantes a su flujo de trabajo de desarrollo: HTML que se puede mostrar correctamente en los navegadores y que también funciona como prototipos estáticos, lo que permite una colaboración más sólida en los equipos de desarrollo.</p><p>Con módulos para Spring Framework, una serie de integraciones con sus herramientas favoritas y la capacidad de conectar su propia funcionalidad, Thymeleaf es ideal para el desarrollo web HTML5 JVM moderno, aunque hay mucho más que puede hacer.</p>\r\n" + 
				"\r\n" + 
				"<br><p></p>")).andExpect(view().name("post"));
		
	}
	
	

}
