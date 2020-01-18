package mx.edu.uacm.blog.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.uacm.blog.domain.Comentario;
import mx.edu.uacm.blog.domain.Post;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.ComentarioService;
import mx.edu.uacm.blog.service.PostService;
import mx.edu.uacm.blog.service.UsuarioService;

@Controller
public class PostController {
	
private static final Logger log=LogManager.getLogger();
	
	//UsuarioService, capa de servicios
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private HttpSession httpSession;
	

	@PostMapping("/post")
    public String insertarPost(Map<String, Object> model){
		
		log.debug("Entrando a insertarPost");

		return "post";
    }
	
	@PostMapping("/postinsert")
    public String insertarPost(Model model,@Param("titulo") String titulo,@Param("url") String url, 
    		                             @Param("contenido") String contenido){
		
		log.debug("Entrando al metodo insertar Post @Controller");
		
		log.debug("Entrando al metodo insertar Post titulo"+titulo);
		log.debug("Entrando al metodo insertar Post url: "+url);
		log.debug("Entrando al metodo insertar Post contenido: "+contenido);
		log.debug("Entrando al metodo insertar Post id del usuario que crea es post: "+httpSession.getAttribute("userID"));
	
		long idUsuario = (long) httpSession.getAttribute("userID");
		
		Usuario usuObtenido =usuarioService.encontrarPorId(idUsuario);
		if(usuObtenido != null) {
			
			Post post = new Post();
			
			post.setTitulo(titulo);
			post.setUrl_post(url);
			post.setContenido_post(contenido);
			post.setUsuario(usuObtenido);
			postService.insertarPost(post);
			
			log.debug("El id del usuario logueado es "+usuObtenido.getId());
		}else {
		
			//model.addAttribute("erro", "Usuario/Contrasena no validos");
		}
		
		return "post";
    }
	
	
	
	@PostMapping("/mostrar")
    public String MostrarContenidoPost(ModelMap model,@RequestParam("idpost") Long idPost){
		
		log.debug("Entrando a metodo MostrarContenidoPost desde PostController");
		
		log.debug("Voy a buscar el pos desde controller y tiene un id: "+idPost);
		Post postObtenido = postService.buscarPostPorId(idPost);
		
		
		model.put("post", postObtenido);
		
		List<Comentario> cometariosPost = comentarioService.obtenerComentariosPorIdPost(idPost);
		log.debug("Comentario: " + cometariosPost.size());


		for (Comentario comentario : cometariosPost) {
			log.debug("El usuario que realizó el comtario es:.................."+comentario.getUsuario().getNombre());
			log.debug(comentario.getId());
			log.debug(comentario.getContenidoComnetario());
			log.debug(comentario.getFechaComentario());
		}
		model.put("comentarios", cometariosPost);
		return  "contenidoPost";
    }
	
		@PostMapping("/comentar")
		public ModelAndView guardarComentario(ModelMap model, @RequestParam("idpost") Long idPost, @RequestParam("contenido") String contenido) {
			log.debug("Entrando a metodo guardarComentario desde PostController ");
			
			log.debug("Voy a buscar el post desde PostController y tiene un id "+idPost);
			Post postObtenido = postService.buscarPostPorId(idPost);
			
			Long idUser = (Long) httpSession.getAttribute("userID");
			
			log.debug("Voy a buscar el usuario desde PostController y tiene un id "+idPost);
			Usuario usuarioObtenido = usuarioService.encontrarPorId(idUser);
			
			Comentario comentario = new Comentario();
			log.debug("El contenido del comentario que voy a agregar es: "+contenido);
			comentario.setContenidoComnetario(contenido);
			comentario.setPost(postObtenido);
			comentario.setUsuario(usuarioObtenido);
			comentarioService.insertarComentario(comentario);
			
			return  new ModelAndView("homeUsuarioLogueado", model);
		}
	
	
	
	
	
}
