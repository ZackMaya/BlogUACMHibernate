package mx.edu.uacm.blog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.uacm.blog.domain.Post;
import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.PostService;
import mx.edu.uacm.blog.service.UsuarioService;

@Controller
public class UsuariosController {

	private static final Logger log=LogManager.getLogger();
	
	//UsuarioService, capa de servicios
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private HttpSession httpSession;
	
	@PostMapping("/home")
	public ModelAndView home(ModelMap model) {
		 
		log.debug("Estoy entrando a home");
        List<Post> posts = postService.obtenerPost();
		
		for (Post post : posts) {
			log.debug("Título del post: "+post.getTitulo());
			log.debug("Contenido del post: "+post.getContenido_post());
			log.debug("Fecha de publicacion del post: "+post.getFecha_post());
			log.debug("Cantidad de comentatios del post: "+post.getComentarios().size());
			
			
		}
			
		model.addAttribute("posts", posts);
		log.debug("Tamaño de la lista de post"+posts.size());
		return  new ModelAndView("home", model);
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(Map model, @Param("mail") String mail,@Param("pass") String pass) {
	    log.debug("Entrando a login");
		//Entidad manejada por el contexto de persistencia
	    log.debug("El mail usuario obtenido es:"+mail);
	    log.debug("El mail usuario obtenido es:"+pass);
	    Usuario usuObtenido =usuarioService.validarUsuarioyContraseña(mail,pass);
		if(usuObtenido != null) {
			httpSession.setAttribute("userLoggenIn", usuObtenido);
			httpSession.setAttribute("username", usuObtenido.getNombre());
			httpSession.setAttribute("userID", usuObtenido.getId());
			log.debug("El id del usuario logueado es "+usuObtenido.getId());
		}else {
		
			//model.put("error", "Usuario/Contrasena no validos");
		}
		
		return new ModelAndView("login",model);
	}
	
	@PostMapping("/autores")
    public String listarAutores(Map<String, Object> model/*ModelMap model*/){
		
		log.debug("Entrando al metodo listar autores");
	
		List<Usuario> usuarios= null;
		
		usuarios = usuarioService.obtenerUsuarios();
		
		for (Usuario usuario : usuarios) {
			log.debug("Nombre del usuario en controller: "+usuario.getNombre());
			log.debug("Post publicados en controller: "+usuario.getPosts().size());
			log.debug("Comentarios publicados en controller: "+usuario.getComentarios().size());
			
		}
		
			
		
		model.put("usuarios",usuarios);
		
		log.debug(usuarios.size());
        //return new ModelAndView("redirect:/", model);
		return "autores";
    }
	
	  @PostMapping("/registra")
	    public String resgistra(Map<String, Object> model){

			return "registra";
	 }
	
	 @PostMapping("/registrar")
	  public String registrarUsuario(Map<String, Object> model,@Param("url") String url,@Param("nombre") String nombre,@Param("ciudad") String ciudad,
			                         @Param("correo") String correo,@Param("password") String password){
			
			log.debug("Entrando al metodo registrar usuario en @Controller");
			
			
			
			log.debug("El correo del usuario a buscar es: "+correo);
			Usuario usuarioObtenido = usuarioService.encontrarPorEmail(correo);
			if (usuarioObtenido == null) {
				
				log.debug("nuevo usuario url"+url);
				log.debug("nuevo usuario nombre: "+nombre);
				log.debug("nuevo usuario correo"+correo);
				log.debug("nuevo usuario ciudad"+ciudad);
				log.debug("nuevo usuario password"+password);
				 Usuario usuario = new Usuario();
				 usuario.setNombre(nombre);
				 usuario.setCuidad(ciudad);
				 usuario.setEmail(correo);
				 usuario.setPassword(password);
				 usuario.setUrl(url);
				 usuarioService.insertarUsuario(usuario);
				
			}
			
			return "home";
	 }
	

	 
	 	 
	
	@PostMapping("/logout")
	public String logout() {
		log.debug("Entrando a logout");
		httpSession.removeAttribute("userLoggenIn");
		httpSession.removeAttribute("username");
		return "home";
	}
	
}
