package mx.edu.uacm.blog.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.blog.service.ComentarioService;
import mx.edu.uacm.blog.service.PostService;
import mx.edu.uacm.blog.service.UsuarioService;
import mx.edu.uacm.blog.BlogProyectoFinalApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class CrearUsuarioAndPostTest {
	
	private static final Logger log = LogManager.getLogger(CrearUsuarioAndPostTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**test para probar la creacion de un usuario y un post**/
	@Test
	public void testCrearUsuario() {
		
		log.debug("Entrando a Test crear usuario");
		
		Usuario usuario = new Usuario();
		usuario.setUrl("https://i.pinimg.com/originals/f3/b5/7e/f3b57ea768813fc5831e88076e93a192.jpg");
		usuario.setNombre("Elena");
		usuario.setEmail("elena@gmail.com");
		usuario.setCuidad("CDMX");
		usuario.setPassword("12345");
		usuarioService.insertarUsuario(usuario);
		
		
	    Post post = new Post();
		post.setTitulo("JPA");
		post.setUrl_post("http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html");
	    post.setContenido_post("<p><br>\r\n" + 
	    		"\r\n" + 
	    		"</p><p><img alt=\"\" src=\"http://www.grupocodesi.com/images/JPAHibernate.jpg\"><br></p><p>Java Persistence API<a target=\"_blank\" rel=\"nofollow\" href=\"http://java.sun.com/javaee/overview/faq/persistence.jsp\">http://java.sun.com/javaee/...</a>Información generalDesarrollador(es)<a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Sun_Microsystems\">Sun Microsystems</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Anexo:G%C3%A9neros_de_software\">Género</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Interfaz_de_programaci%C3%B3n_de_aplicaciones\">interfaz de programación de aplicaciones</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Lenguaje_de_programaci%C3%B3n\">Programado en</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Lenguaje_de_programaci%C3%B3n_Java\">Java</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Sistema_operativo\">Sistema operativo</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/M%C3%A1quina_virtual_Java\">Máquina virtual Java</a><a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Licencia_de_software\">Licencia</a><i><b>?</b></i></p><div>[<a target=\"_blank\" rel=\"nofollow\" href=\"https://www.wikidata.org/wiki/Q908660\">editar datos en Wikidata</a>]</div><p><b>Java Persistence API</b>, más conocida por sus siglas <b>JPA</b>, es la API de persistencia desarrollada para la plataforma <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Java_EE\">Java EE</a></p><p>Es un framework del lenguaje de programación Java que maneja datos relacionales en aplicaciones usando la Plataforma Java en sus ediciones Standard (<a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Java_SE\">Java SE</a>) y Enterprise (<a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Java_EE\">Java EE</a>).</p><p>La JPA se origina a partir del trabajo del <a target=\"_blank\" rel=\"nofollow\" href=\"https://www.jcp.org/en/jsr/detail?id=220\">JSR 220</a>&nbsp;Expert Group el cual correspondía a <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/EJB\">EJB</a>3. JPA 2.0 sería el trabajo del <a target=\"_blank\" rel=\"nofollow\" href=\"https://www.jcp.org/en/jsr/detail?id=317\">JSR 317</a>&nbsp;y posteriormente JPA 2.1 en el <a target=\"_blank\" rel=\"nofollow\" href=\"https://www.jcp.org/en/jsr/detail?id=338\">JSR 338</a>.</p><p><br></p><p><br></p><p>Persistencia en este contexto cubre tres áreas:</p><ul><li>La <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Interfaz_de_programaci%C3%B3n_de_aplicaciones\">API</a>&nbsp;en sí misma, definida en el paquete <code>javax.persistence</code></li><li>El lenguaje de consulta <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Java_Persistence_Query_Language\">Java Persistence Query Language</a>&nbsp;(JPQL).</li><li>Metadatos objeto/relacional.</li></ul><p>El objetivo que persigue el diseño de esta API es no perder las ventajas de la orientación a objetos al interactuar con una base de datos (siguiendo el patrón de <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Mapeo_objeto-relacional\">mapeo objeto-relacional</a>), como sí pasaba con EJB2, y permitir usar objetos regulares (conocidos como <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/POJO\">POJOs</a>).</p>\r\n" + 
	    		"\r\n" + 
	    		"<br><p></p>");
		usuario.addPost(post);	
		usuarioService.insertarUsuario(usuario);

	}
	
	

	
}
