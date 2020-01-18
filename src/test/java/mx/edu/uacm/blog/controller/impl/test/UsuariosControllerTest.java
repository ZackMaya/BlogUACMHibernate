package mx.edu.uacm.blog.controller.impl.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import mx.edu.uacm.blog.BlogProyectoFinalApplication;
import mx.edu.uacm.blog.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
@AutoConfigureMockMvc  //configurar mvc
public class UsuariosControllerTest {
	
	private static final Logger log = LogManager.getLogger(UsuariosControllerTest.class);
	
	//permite simular la peticion
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
   /**test para home**/
	@Test
	public void testHome() throws Exception {
		
		log.debug("entrando a testHome");
		mvc.perform(get("/")).andExpect(view().name("home"));
	}
	
	
	/**test para login**/
	@Test
	public void testLogin() throws Exception {
		
		log.debug("Entrando a testLogin");
		
		ResultActions resultAction = this.mvc.perform(post("/login").param("mail", "maya@gmail.com").param("pass", "12345")).andExpect(view().name("login"));
		
		MvcResult mvcResult = resultAction.andReturn();
		
		MockHttpSession mockHttpSession = (MockHttpSession)  mvcResult.getRequest().getSession();
		
		RequestBuilder resqBuild = MockMvcRequestBuilders.post("/login").session(mockHttpSession);
		
		mockHttpSession.getAttribute("userLoggenIn");
		
		assertThat(mockHttpSession.getAttribute("userLoggenIn"), is(not(nullValue())));
		
	}

	    /**test para ver autores**/
		@Test
		public void testVisualizarAutores() throws Exception {
			
			log.debug("Entrando a testVisualizarAutores");
			mvc.perform(post("/autores")).andExpect(view().name("autores"));
		}
		
		
		/**test para ver posts**/
		@Test
		public void testVisualizaPost() throws Exception {
			
			log.debug("Entrando a testVisualizarAutores");
			mvc.perform(post("/post")).andExpect(view().name("post"));
		}
	
	
	/**test para registro de usuario**/
	/*@Test
	public void testRegistrarUsuario() throws Exception {
		log.debug("Entrando a registrarUsuarioTest");
		
		mvc.perform(post("/registrar").param("url", "https://i.pinimg.com/originals/f3/b5/7e/f3b57ea768813fc5831e88076e93a192.jpg").param("nombre", "elena").param("ciudad", "CDMX").param("correo", "elena@gmail.com")
				                   .param("password", "12345")).andExpect(view().name("home"));
		
	}*/
	
	
		


}
