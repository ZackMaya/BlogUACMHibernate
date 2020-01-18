package mx.edu.uacm.blog.domain;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.ComentarioService;
import mx.edu.uacm.blog.service.PostService;
import mx.edu.uacm.blog.service.UsuarioService;
import mx.edu.uacm.blog.BlogProyectoFinalApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class CrearUsuarioPostAndCommentaryTest {
	
	private static final Logger log = LogManager.getLogger(CrearUsuarioPostAndCommentaryTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	@Test
	public void crearUsuario() {
		
	   log.debug("Entrando a Test crear usuario");

		
	   log.debug("Entrando a Test crear usuario");
		Usuario usuario = new Usuario();
		usuario.setUrl("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
		usuario.setNombre("Raquel");
		usuario.setCuidad("CDMX");
		usuario.setEmail("raquel@gmail.com");
		usuario.setPassword("12345");
		usuarioService.insertarUsuario(usuario);
		
		
	    Post post = new Post();
		post.setTitulo("ORM");
		post.setUrl_post("https://es.wikipedia.org/wiki/Mapeo_objeto-relacional");
		post.setContenido_post("<p>\r\n" + 
				"\r\n" + 
				"</p><p>En la <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Programaci%C3%B3n_orientada_a_objetos\">programación orientada a objetos</a>, las tareas de <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Gesti%C3%B3n_de_datos\">gestión de datos</a>&nbsp;son implementadas generalmente por la manipulación de <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Objeto_(programaci%C3%B3n)\">objetos</a>, los cuales son casi siempre valores no <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Escalar_(inform%C3%A1tica)\">escalares</a>. Para ilustrarlo, considere el ejemplo de una entrada en una libreta de direcciones, que representa a una sola persona con cero o más números telefónicos y cero o más direcciones. En una implementación orientada a objetos, esto puede ser modelado por un \"objeto persona\" con \"campos\" que almacenan los datos de dicha entrada: el nombre de la persona, una lista de números telefónicos y una lista de direcciones. La lista de números telefónicos estaría compuesta por \"objetos de números telefónicos\" y así sucesivamente. La entrada de la libreta de direcciones es tratada como un valor único por el lenguaje de programación (puede ser referenciada por una sola variable, por ejemplo). Se pueden asociar varios métodos al objeto, como uno que devuelva el número telefónico preferido, la dirección de su casa, etc..</p><p>Sin embargo, muchos productos populares de base de datos, como los <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Sistema_de_gesti%C3%B3n_de_bases_de_datos\">Sistemas de Gestión de Bases de Datos</a>&nbsp;<a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/SQL\">SQL</a>, solamente pueden almacenar y manipular valores escalares como enteros y cadenas, organizados en <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Tabla_(base_de_datos)\">tablas</a>&nbsp;<a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Normalizaci%C3%B3n_de_bases_de_datos\">normalizadas</a>. El programador debe convertir los valores de los objetos en grupos de valores simples para almacenarlos en la base de datos (y volverlos a convertir luego de recuperarlos de la base de datos), o usar sólo valores escalares simples en el programa. El mapeo objeto-relacional es utilizado para implementar la primera aproximación.</p><p>El núcleo del problema reside en traducir estos objetos a formas que puedan ser almacenadas en la base de datos para recuperarlas fácilmente, mientras se preservan las propiedades de los objetos y sus relaciones; estos objetos se dice entonces que son <a target=\"_blank\" rel=\"nofollow\" href=\"https://es.wikipedia.org/wiki/Persistencia_(inform%C3%A1tica)\">persistentes</a>.</p>\r\n" + 
				"\r\n" + 
				"<br><p></p>");
			usuario.addPost(post);	
		
		usuario.addPost(post);	
		
		usuarioService.insertarUsuario(usuario);
		
		Comentario comentario = new Comentario();
		comentario.setUsuario(usuario);
		comentario.setContenidoComnetario("Java no me gusta :/");
		
		post.addCommentary(comentario);
		
		comentarioService.insertarComentario(comentario);

	
		
	}
	
	

	
}
